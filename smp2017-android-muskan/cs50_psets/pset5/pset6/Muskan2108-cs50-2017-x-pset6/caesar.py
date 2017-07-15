import cs50
import sys
def main():
    if len(sys.argv)>2:
        print("Too many arguments supplied")
        exit(1)
    elif len(sys.argv)<=1:
       print("One argument expected")
       exit(1)
    else:
       k=int(sys.argv[1])
       k=k%26
       cipher=[]
       print("plaintext:",end="")
       plain=cs50.get_string()
       for i in plain:
           if i.isalpha():
               cipher.append(caesar(i,k))
           else:
                cipher.append(i)
                
       print("ciphertext:",end="")
       print("".join(cipher))
       exit(0)
def caesar(char,key):
      if char.isupper():
        return chr(((ord(char) - 65 + key) % 26) + 65)
      else:
        return chr(((ord(char) - 97 + key) % 26) + 97)
if __name__ == "__main__":
    main()
    
    