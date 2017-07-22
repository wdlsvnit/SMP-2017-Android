import cs50
c=0
print("O hai! How much change is owed?")
f=cs50.get_float()
while True:
    if f<0:
        print("How much change is owed?")
        f=cs50.get_float()
    else:
        break
t=int(round(f*100))
s=t-(t%25)
c+=s/25
t=t-s
s=t-(t%10)
c+=s/10
t=t-s
s=t-(t%5)
c+=s/5
t=t-s
c+=t
print("{}".format(c))