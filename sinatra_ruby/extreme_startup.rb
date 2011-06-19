require 'rubygems'
require 'sinatra'

configure do
  set :port, 1337
end

get '/' do
  "johannes"
end
