t = int(raw_input())
for a0 in xrange(t):
    n = int(raw_input())
    S = map(int,raw_input().split())
    m = [sum(S[i:j]) for i in xrange(len(S)) for j in xrange(i+1,len(S)+1)]