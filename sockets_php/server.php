<?
require 'solver.php';
$host = "127.0.0.1";
$port = 9000;
set_time_limit(0);
$socket = socket_create(AF_INET, SOCK_STREAM, SOL_TCP); 
$result = socket_bind($socket, $host, $port);
$result = socket_listen($socket, SOMAXCONN);
while (true) {
  $spawn = socket_accept($socket);
  $input = socket_read($spawn, 1024, PHP_NORMAL_READ);
  $input = trim($input);
 
  $answer = solve($input);

  $result = "HTTP/1.0 200 OK\n";
  $result .= "Date: Sat, 22 Dec 2012 00:00:01 GMT\n";
  $result .= "Content-Type: text/html\n";
  $result .= "Content-Length: " . strlen($answer) . "\n";
  $result .= "\n";
  $result .= $answer;

  $written = socket_write($spawn, $result, strlen($result));

  echo "Request: $input\n";
  echo "Answer: $answer\n";
}
?>
