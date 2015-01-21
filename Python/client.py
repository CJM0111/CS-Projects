#!/usr/bin/env python
import socket
import sys

def main(argv):
    server = argv[0]
    port = argv[1]

    #create an INET, STREAMing socket
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # now connect server on the specified port
    s.connect((server, port))

    message = "GET / HTTP/1.1\nHost: " + server + "\n\n"
    s.send(message)

    # receive and print 1024 B of response
    response = s.recv(2048)
    print("Received from %s: %s" % (server, str(response)))

    s.close()

if __name__ == "__main__":
    main( ['blue.butler.edu', 80] )
