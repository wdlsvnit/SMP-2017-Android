from nltk.tokenize import TweetTokenizer
from helpers import get_user_timeline
class Analyzer():
    """Implements sentiment analysis."""

    def __init__(self, positives, negatives):
         
        def load(f):
            words = []
            with open(f) as file:
                for line in file:
                    if line.startswith(';') or line.startswith('\n'):
                        continue
                    words.extend(line.split())
                return set(words)
                
        self.positive = load(positives)
        self.negative = load(negatives)
    
    
        # TODO
    def analyze(self, text):
        """Analyze text for sentiment, returning its score."""
        if text in self.positive:
            return 1
        elif text in self.negative:
            return -1
        else:
            return 0
        
