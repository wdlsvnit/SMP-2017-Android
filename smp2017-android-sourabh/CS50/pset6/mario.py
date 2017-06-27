a=0
while a!=1:
    try:
        n = int(input())
        a=1
    except:
        a=0
        
for i in range(2,n+2):
    print('#'*i)