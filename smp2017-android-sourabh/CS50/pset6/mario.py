a=0
while a!=1:
    try:
        n = int(input('Enter the Value of n:'))
        a=1
    except:
        a=0
        
for i in range(2,n+2):
	print(' '*(n-i+1),end='')    
	print('#'*i,end='')
	print(' '*2,end='')
	print('#'*i)
