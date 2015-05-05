f=open("/home/mark/data/Clio_Duplicated.csv","rw")
def cleancomma(s):
    index= s.find(",,")
    if index!=-1:
        return(cleancomma(s[0:(1+index)]+'""'+s[(1+index):]))
    else:
        return(s)
def cleancsv(s):
    m=cleancomma(s)
    return(m[1:].replace("\r\n","\n"))
def samecolumn(g,i):
    j=0
    d=[]
    result=[]
    while j<len(g):
        d.append(g[j][i])
        j+=1
    j=0
    while j<len(d):
        result.append([g[j][i]==m for m in d])
        j+=1
    return(result)
def mergeresult(r1,r2):
    i=0
    while i<len(r1):
        j=0
        while j<len(r1[i]):
            r1[i][j]=r1[i][j] or r2[i][j]
            j+=1
        i+=1
def ifsameperson(g):
    r1=samecolumn(g,3)
    r2=samecolumn(g,4)
    r3=samecolumn(g,6)
    r4=samecolumn(g,7)
    mergeresult(r1,r2)
    mergeresult(r1,r3)
    mergeresult(r1,r4)
    i=1
    name=g[0][14]
    label=[name+str(0)]
    while i<len(g):
        j=0
        while j<i:
            if r1[i][j]:
                label.append(name+str(j))
                break
            else:
                if (j+1)==i:
                    label.append(name+str(i))
            j+=1
        i+=1
    return(label)
columnnames=cleancsv(f.readline())
line=cleancsv(f.readline())
fullname=line.split('","')[14]
#section=""
section=[]
f1=open("/home/mark/data/clean.csv","wr")
ii=1
while line!='':
    cells=line.split('","')
    nl=cleancsv(f.readline())
    print (ii)
    ii+=1
    if fullname==cells[14]:
        section.append(cells)
    if fullname!=cells[14] or nl=='':
        #print "write"
        #f1=open("/home/mark/data/clio/"+fullname.replace('"','')+".csv","wr")
        #writelines(section)
        #f1.close()
        j=0
        sp=ifsameperson(section)
        while j<len(section):
            section[j].insert(0, sp[j])
            wrb=("".join(['"'+iii+'",'  for iii in section[j]]))
            f1.writelines(wrb[:len(wrb)-1])
            j+=1
        section=[]
        section.append(cells)
        fullname=cells[14]
    line=nl
f.close()
f1.close()
