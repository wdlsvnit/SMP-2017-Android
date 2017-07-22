import nltk

class Analyzer():
    

    def __init__(self, positives, negatives):
        self.positive = set()
        file = open(positives, "r")
        for line in file:
            if line.startswith(';') == False:
                self.positive.add(line.rstrip("\n"))
        file.close()
        
        self.negative = set()
        file = open(negatives, "r")
        for line in file:
            if line.startswith(';') == False:
                self.negative.add(line.rstrip("\n"))
        file.close()

    def analyze(self, text):
        
        tokenizer = nltk.tokenize.TweetTokenizer()
        tokens = tokenizer.tokenize(text)
        total = 0
        for word in tokens:
            if word.lower() in self.positive:
                total += 1
            elif word.lower() in self.negative:
                total -= 1
            else:
                continue
        
        return total
