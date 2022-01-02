#https://www.30secondsofcode.org/python/s/decapitalize
def decapitalize(s, upper_rest = False):
  return ''.join([s[:1].lower(), (s[1:].upper() if upper_rest else s[1:])])