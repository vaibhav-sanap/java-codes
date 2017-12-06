from sys import stdin
t = int(input())
while(t>0):
    n = int(input())
    module = n%12
    if(module==0):
        print( str(n-11)+" WS")
    if(module==1):
        print( str(n+11)+" WS")
    if(module==2):
        print( str(n+9)+" MS")
    if(module==3):
        print( str(n+7)+" AS")
    if(module==4):
        print( str(n+5)+" AS")
    if(module==5):
        print( str(n+3)+" MS")
    if(module==6):
        print( str(n+1)+" WS")
    if(module==7):
        print( str(n-1)+" WS")
    if(module==8):
        print( str(n-3)+" MS")
    if(module==9):
        print( str(n-5)+" AS")
    if(module==10):
        print( str(n-7)+" AS")
    if(module==11):
        print( str(n-9)+" MS")
    t=t-1