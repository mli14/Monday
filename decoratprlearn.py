# functools 学习
import functools
# functools.partial
def afunction(*k):
    for i in k:
        print i
    pass
pafunction=functools.partial(afunction,1)
pafunction(2)
pafunction(range(10))
print pafunction.func
print pafunction.args
print pafunction.keywords
print "Re-define afunction"
def afunction(*k,**ss):
    for i in k:
        print str(i)+"    redifined!"
    pass
#pafunction=functools.partial(afunction,1,a=1)
pafunction(2)
pafunction(range(10))
print pafunction.func
print pafunction.args
print pafunction.keywords
# 相当于返回一个第一个参数已经固定了之后的afunction， 返回结果为pafunction， 再对
# pafunction调用相当于： pafunction(arg)=afunction(1,arg)，在这之后再改动afunction
# 不会对pfunction再产生任何影响。

# functools.update_wrapper
##WRAPPER_ASSIGNMENTS = ('__module__', '__name__', '__doc__')
##WRAPPER_UPDATES = ('__dict__',)
##def update_wrapper(wrapper,
##                   wrapped,
##                   assigned = WRAPPER_ASSIGNMENTS,
##                   updated = WRAPPER_UPDATES):
##    """Update a wrapper function to look like the wrapped function
##
##       wrapper is the function to be updated
##       wrapped is the original function
##       assigned is a tuple naming the attributes assigned directly
##       from the wrapped function to the wrapper function (defaults to
##       functools.WRAPPER_ASSIGNMENTS)
##       updated is a tuple naming the attributes of the wrapper that
##       are updated with the corresponding attribute from the wrapped
##       function (defaults to functools.WRAPPER_UPDATES)
##    """
##    for attr in assigned:
##        setattr(wrapper, attr, getattr(wrapped, attr))
##    for attr in updated:
##        getattr(wrapper, attr).update(getattr(wrapped, attr, {}))
##    # Return the wrapper so this can be used as a decorator via partial()
##    return wrapper
def decorator(f):
    print "decorator called\n"
    pass
wrappedfunction=functools.update_wrapper(decorator,afunction)
# functools.update_wrapper 这个function的功能就是把wrapper的元数据用wrapped的元数据
# 进行更新 例如：

"""class wrapperdiy():
    def __init__(self,module,name,doc):
        self.__module__=module
        self.__name__=name
        self.__doc__=doc
    
awrapperdiyinstance=wrapperdiy("original module","original name","original doc")
bwrapperdiyinstance=wrapperdiy("Updated module","Updated name","Updated doc")
functools.update_wrapper(awrapperdiyinstance,bwrapperdiyinstance)
# 这样awrapperdiyinstance的元数据就被update成bwrapperdiyinstance的元数据了
# assigned和updated的区别主要在于元数据的类型， 可以通过赋值改变的就传到ssigned， 如字符串
# 类型， updated是用来调用字典的update的方法的"""

# functools.wraps
##WRAPPER_ASSIGNMENTS = ('__module__', '__name__', '__doc__')
##WRAPPER_UPDATES = ('__dict__',)
##def wraps(wrapped,
##          assigned = WRAPPER_ASSIGNMENTS,
##          updated = WRAPPER_UPDATES):
##    """Decorator factory to apply update_wrapper() to a wrapper function
##
##       Returns a decorator that invokes update_wrapper() with the decorated
##       function as the wrapper argument and the arguments to wraps() as the
##       remaining arguments. Default arguments are as for update_wrapper().
##       This is a convenience function to simplify applying partial() to
##       update_wrapper().
##    """
##    return partial(update_wrapper, wrapped=wrapped,
##                   assigned=assigned, updated=updated)
p1afunction=functools.wraps(afunction)
print p1afunction.func
# 用decorator机制调用update_Wrapper, functools.wrap(func)相当于
# 得到一个partial(update_wrapper, wrapped=wrapped,
#                   assigned=assigned, updated=updated)
# 的结果。

##def cmp_to_key(mycmp):
##    """Convert a cmp= function into a key= function"""
##    class K(object):
##        __slots__ = ['obj']
##        def __init__(self, obj, *args):
##            self.obj = obj
##        def __lt__(self, other):
##            return mycmp(self.obj, other.obj) < 0
##        def __gt__(self, other):
##            return mycmp(self.obj, other.obj) > 0
##        def __eq__(self, other):
##            return mycmp(self.obj, other.obj) == 0
##        def __le__(self, other):
##            return mycmp(self.obj, other.obj) <= 0
##        def __ge__(self, other):
##            return mycmp(self.obj, other.obj) >= 0
##        def __ne__(self, other):
##            return mycmp(self.obj, other.obj) != 0
##        def __hash__(self):
##            raise TypeError('hash not implemented')
##    return K

