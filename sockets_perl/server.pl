#!/usr/bin/perl

use IO::Socket; 
use strict;

sub solve() {
	my ($input) = @_;
	return $input;
}

my $sock = new IO::Socket::INET (
	LocalHost => '0.0.0.0',
	LocalPort => '9000',
	Proto => 'tcp',
	Listen => 1,
	Reuse => 1,
);

die "Could not create socket: $!\n" unless $sock;

while (my $new_sock = $sock->accept()) {
	my $name = gethostbyaddr($new_sock->peeraddr, AF_INET);
	my $port = $new_sock->peerport;
	print "Connection from $name port $port\n";
	my $input;
	my $answer;
	$_ = <$new_sock>;
	s/\x0d$//;
	s/\x0a$//;
	$input = $_;
	$answer = &solve($input);
	my $result = "HTTP/1.0 200 OK\n";
	$result .= "Date: Sat, 22 Dec 2012 00:00:01 GMT\n";
	$result .= "Content-Type: text/html\n";
	$result .= "Content-Length: " . length($answer) . "\n";
	$result .= "\n";
	$result .= $answer;
	print $new_sock $result;
	close $new_sock;
	print "Request: $input\n";
	print "Answer: $answer\n";
}
close($sock);
