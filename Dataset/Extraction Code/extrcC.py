with open("C:\\Users\\star\\Desktop\\AboutMe\\Related2Uni\\Courses\\bil476\\Project\\Dataset\\sorted_data\\toys_&_games\\all.review") as infile, open("C:\\Users\\star\\Desktop\\AboutMe\\Related2Uni\\Courses\\bil476\\Project\\Dataset\\sorted_data\\toys_&_games\\comments.txt", 'w') as outfile:
    copy = False
    for line in infile:
        if line.strip() == "<review_text>":
            copy = True
            continue
        elif line.strip() == "</review_text>":
            copy = False
            continue
        elif copy:
        	if not len(line.strip()) == 0:
           		outfile.write("\"" +line.rstrip()+"\",\n")

with open("C:\\Users\\star\\Desktop\\AboutMe\\Related2Uni\\Courses\\bil476\\Project\\Dataset\\sorted_data\\toys_&_games\\all.review") as infile, open("C:\\Users\\star\\Desktop\\AboutMe\\Related2Uni\\Courses\\bil476\\Project\\Dataset\\sorted_data\\toys_&_games\\ratings.txt", 'w') as outfile:
    copy = False
    for line in infile:
        if line.strip() == "<rating>":
            copy = True
            continue
        elif line.strip() == "</rating>":
            copy = False
            continue
        elif copy:
            outfile.write(line)

combine =[]

with open("C:\\Users\\star\\Desktop\\AboutMe\\Related2Uni\\Courses\\bil476\\Project\\Dataset\\sorted_data\\toys_&_games\\ratings.txt") as xh:
  with open("C:\\Users\\star\\Desktop\\AboutMe\\Related2Uni\\Courses\\bil476\\Project\\Dataset\\sorted_data\\toys_&_games\\comments.txt") as yh:
    with open("C:\\Users\\star\\Desktop\\AboutMe\\Related2Uni\\Courses\\bil476\\Project\\Dataset\\sorted_data\\toys_&_games\\r&c.txt","w") as zh:
      #Read first file
      xlines = xh.readlines()
      #Read second file
      ylines = yh.readlines()
      #Combine content of both lists
      #combine = list(zip(ylines,xlines))
      #Write to third file
      for i in range(len(xlines)):
        line = ylines[i].strip() + ' ' + xlines[i]
        zh.write(line)