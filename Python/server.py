#!/usr/bin/env python
import os
import socket
from webob import Response

def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.bind(('',8080))
    sock.listen(5)
    while True:
        conn, client_address = sock.accept()
        data = conn.recv(1024)
        print('received "%s"'% (data))        
        res = Response()
        res.body = 'Hello, world'
        conn.send(str(res))
        conn.close()


if __name__ == '__main__':
    main()
