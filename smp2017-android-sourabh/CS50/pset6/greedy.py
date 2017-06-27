a=0
while a!=1:
    try:
        print('O hai! How much change is owed?')
        n = float(input())
        a=1
    except:
        a=0
coins = [25,10,5,1]
count=0
n= (n -int(n))*100
for i in coins:
    count += int(n/i)
    n = n%i
print(count)
