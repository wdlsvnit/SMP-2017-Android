import cs50
print("Height: ", end="")
n=cs50.get_int()
while True:
    if n>=0 and n<=23:
        break
    else:
        print("Height: ", end="")
        n=cs50.get_int()
for i in range(n):
    for j in range(i+2,n+1):
        print(" ",end="")
    for k in range(-1,i+1):
        print("#",end="")
    print("")
        