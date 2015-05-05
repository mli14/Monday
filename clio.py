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

columnnames=cleancsv(f.readline())
line=cleancsv(f.readline())
fullname=line.split('","')[14]
section=""
ii=1
while line!='':
    cells=line.split('","')
    print (ii)
    print fullname
    ii+=1
    if fullname==cells[14]:
        section+=line
    else:
        print "write"
        f1=open("/home/mark/data/clio/"+fullname.replace('"','')+".csv","wr")
        f1.writelines(section)
        f1.close()
        section=line
        fullname=cells[14]
    line=cleancsv(f.readline())
f.close()
