import sys
if len(sys.argv)!=2:
    print('meh')
    sys.exit()
n=int(sys.argv[1])
stri = list(input("Plaintext:"))

for i in range(len(stri)):
    
    if ord(stri[i]) not in range(ord('a'),ord('z')+1) and ord(stri[i]) not in range(ord('A'),ord('Z')+1):
        continue
    
    elif ord(stri[i]) in range(ord('a'),ord('z')+1):
        stri[i] = chr(ord(stri[i])+n)
    
        while ord(stri[i]) not in range(ord('a'),ord('z')+1):
            stri[i] = chr(ord(stri[i])-26)
    
    elif ord(stri[i]) in range(ord('A'),ord('Z')+1):
        stri[i] = chr(ord(stri[i])+n)
    
        while ord(stri[i]) not in range(ord('A'),ord('Z')+1):
            stri[i] = chr(ord(stri[i])-26)
        
print("ciphertext:{}".format(''.join(stri)))
