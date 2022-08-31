def isfloat(num):
    try:
        float(num)
        return True
    except ValueError:
        return False

handeler = open('input.txt')
text = handeler.read()
#print(text)
keyWords = ['auto', 'break', 'case', 'char', 'const', 'continue', 'default', 'do', 'double', 'else', 'enum', 'extern', 'float', 'for', 'goto', 'if', 'int', 'long', 'register', 'return', 'short', 'signed', 'sizeof', 'static', 'struct', 'switch', 'typedef', 'union', 'unsigned', 'void', 'volatile', 'while', 'bool', '_Packed']
othersKey = ['{','}','(',')','[',']',';']
arithmatricOperator = ['+','-','%','=','/','*']
LogicalOp = ['>','<','==','!=','!','&&','>=','<=','||']
othersOp =['?:', '&', '|', '<<', '>>', '~','^','+=','-=','*=','/=','%=','++', '--']
Founded_keyWords = []
Founded_Identifiers = []
LogicalOperator = []
Found_arithmatricOperator = []
Numerical_values = []
other= []
lst = text.split('\n')
for item in lst:
	tmp = item.strip()
	if len(other)==0 and tmp[-1] == ';' and tmp[-1] not in other:
		other.append(tmp[-1])
	fhalf = tmp.split(';')
	#print(fhalf,'=====')
	data = fhalf[0].split()
	#print(data)
	for word in data:
		#print(type(word),word)
		if word in othersKey:
			if word not in other:
				other.append(word)
		elif word in arithmatricOperator:
			if word not in Found_arithmatricOperator:
				Found_arithmatricOperator.append(word)
		elif word in LogicalOp:
			if word not in LogicalOperator:
				LogicalOperator.append(word) 
		elif word in keyWords:
			if word not in Founded_keyWords and word== 'else' and len(data)>data.index(word)+1:
				if data[data.index(word)+1] == 'if':
					Founded_keyWords.append('else if')
			else:
				Founded_keyWords.append(word)
		elif (word.isdigit() or isfloat(word)) and word not in Numerical_values:
			Numerical_values.append(word)
		elif word in othersOp:
			pass
		else:
			if word != ',' and word not in Founded_Identifiers:
				Founded_Identifiers.append(word)
print('keyWords:',Founded_keyWords)
print('Identifiers:',Founded_Identifiers)
print('Math Operators:',Found_arithmatricOperator)
print('Logical Operators:',LogicalOperator)
print('Numerical Values:',Numerical_values)
print('Others:',other)