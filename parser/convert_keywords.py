#!/usr/bin/env python3

import re

inp = open('Kotlin.g4', 'r').read().strip()

keywords = []

for match in re.findall("'.*?'", inp):
    inside = match.strip("'")
    if not inside.isalpha() or inside[0].isupper():
        continue
    keywords.append(inside)

keywords = list(set(keywords))
print(keywords)

maps = ['KW_{}'.format(x.upper()) for x in keywords]

print(' | '.join(maps))

for k, m in zip(keywords, maps):
    inp = inp.replace("'{}'".format(k), m)

#print(inp)

#for k, m in zip(keywords, maps):
#    print("{} : '{}' ;".format(m, k))
