/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  org.python.core.AllFunction
 *  org.python.core.AnyFunction
 *  org.python.core.BuiltinFunctions
 *  org.python.core.CompileFunction
 *  org.python.core.CompileMode
 *  org.python.core.CompilerFlags
 *  org.python.core.ImportFunction
 *  org.python.core.MaxFunction
 *  org.python.core.MinFunction
 *  org.python.core.OpenFunction
 *  org.python.core.Py
 *  org.python.core.PyAttributeDeleted
 *  org.python.core.PyBaseCode
 *  org.python.core.PyBaseString
 *  org.python.core.PyBoolean
 *  org.python.core.PyCallIter
 *  org.python.core.PyClassMethod
 *  org.python.core.PyCode
 *  org.python.core.PyComplex
 *  org.python.core.PyDictionary
 *  org.python.core.PyEnumerate
 *  org.python.core.PyException
 *  org.python.core.PyFile
 *  org.python.core.PyFloat
 *  org.python.core.PyFrame
 *  org.python.core.PyFrozenSet
 *  org.python.core.PyInteger
 *  org.python.core.PyList
 *  org.python.core.PyLong
 *  org.python.core.PyModule
 *  org.python.core.PyObject
 *  org.python.core.PyProperty
 *  org.python.core.PyReversedIterator
 *  org.python.core.PySet
 *  org.python.core.PySlice
 *  org.python.core.PyStaticMethod
 *  org.python.core.PyString
 *  org.python.core.PyStringMap
 *  org.python.core.PySuper
 *  org.python.core.PySystemState
 *  org.python.core.PyTuple
 *  org.python.core.PyType
 *  org.python.core.PyUnicode
 *  org.python.core.PyXRange
 *  org.python.core.RoundFunction
 *  org.python.core.SortedFunction
 *  org.python.core.imp
 *  org.python.core.util.RelativeFile
 */
package org.python.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import org.python.core.AllFunction;
import org.python.core.AnyFunction;
import org.python.core.BuiltinFunctions;
import org.python.core.CompileFunction;
import org.python.core.CompileMode;
import org.python.core.CompilerFlags;
import org.python.core.ImportFunction;
import org.python.core.MaxFunction;
import org.python.core.MinFunction;
import org.python.core.OpenFunction;
import org.python.core.Py;
import org.python.core.PyAttributeDeleted;
import org.python.core.PyBaseCode;
import org.python.core.PyBaseString;
import org.python.core.PyBoolean;
import org.python.core.PyCallIter;
import org.python.core.PyClassMethod;
import org.python.core.PyCode;
import org.python.core.PyComplex;
import org.python.core.PyDictionary;
import org.python.core.PyEnumerate;
import org.python.core.PyException;
import org.python.core.PyFile;
import org.python.core.PyFloat;
import org.python.core.PyFrame;
import org.python.core.PyFrozenSet;
import org.python.core.PyInteger;
import org.python.core.PyList;
import org.python.core.PyLong;
import org.python.core.PyModule;
import org.python.core.PyObject;
import org.python.core.PyProperty;
import org.python.core.PyReversedIterator;
import org.python.core.PySet;
import org.python.core.PySlice;
import org.python.core.PyStaticMethod;
import org.python.core.PyString;
import org.python.core.PyStringMap;
import org.python.core.PySuper;
import org.python.core.PySystemState;
import org.python.core.PyTuple;
import org.python.core.PyType;
import org.python.core.PyUnicode;
import org.python.core.PyXRange;
import org.python.core.RoundFunction;
import org.python.core.SortedFunction;
import org.python.core.imp;
import org.python.core.util.RelativeFile;
import org.python.util.CurrentLine;
public class __builtin__ {
	private static final PyStringMap internedStrings = new PyStringMap();
	public static PyString __doc__zip = new PyString("zip(seq1 [, seq2 [...]]) -> [(seq1[0], seq2[0] ...), (...)]\n\nReturn a list of tuples, where each tuple contains the i-th element\nfrom each of the argument sequences.  The returned list is\ntruncated in length to the length of the shortest argument sequence.");

	public static void fillWithBuiltins(PyObject dict) {
		dict.__setitem__("object", (PyObject)PyObject.TYPE);
		dict.__setitem__("type", (PyObject)PyType.TYPE);
		dict.__setitem__("bool", (PyObject)PyBoolean.TYPE);
		dict.__setitem__("int", (PyObject)PyInteger.TYPE);
		dict.__setitem__("enumerate", (PyObject)PyEnumerate.TYPE);
		dict.__setitem__("float", (PyObject)PyFloat.TYPE);
		dict.__setitem__("long", (PyObject)PyLong.TYPE);
		dict.__setitem__("complex", (PyObject)PyComplex.TYPE);
		dict.__setitem__("dict", (PyObject)PyDictionary.TYPE);
		dict.__setitem__("list", (PyObject)PyList.TYPE);
		dict.__setitem__("tuple", (PyObject)PyTuple.TYPE);
		dict.__setitem__("set", (PyObject)PySet.TYPE);
		dict.__setitem__("frozenset", (PyObject)PyFrozenSet.TYPE);
		dict.__setitem__("property", (PyObject)PyProperty.TYPE);
		dict.__setitem__("staticmethod", (PyObject)PyStaticMethod.TYPE);
		dict.__setitem__("classmethod", (PyObject)PyClassMethod.TYPE);
		dict.__setitem__("super", (PyObject)PySuper.TYPE);
		dict.__setitem__("str", (PyObject)PyString.TYPE);
		dict.__setitem__("unicode", (PyObject)PyUnicode.TYPE);
		dict.__setitem__("basestring", (PyObject)PyBaseString.TYPE);
		dict.__setitem__("file", (PyObject)PyFile.TYPE);
		dict.__setitem__("slice", (PyObject)PySlice.TYPE);
		dict.__setitem__("xrange", (PyObject)PyXRange.TYPE);
		dict.__setitem__("None", Py.None);
		dict.__setitem__("NotImplemented", Py.NotImplemented);
		dict.__setitem__("Ellipsis", Py.Ellipsis);
		dict.__setitem__("True", (PyObject)Py.True);
		dict.__setitem__("False", (PyObject)Py.False);
		dict.__setitem__("__debug__", (PyObject)Py.One);
		dict.__setitem__("abs", (PyObject)new BuiltinFunctions("abs", 7, 1));
		dict.__setitem__("apply", (PyObject)new BuiltinFunctions("apply", 9, 1, 3));
		dict.__setitem__("callable", (PyObject)new BuiltinFunctions("callable", 14, 1));
		dict.__setitem__("coerce", (PyObject)new BuiltinFunctions("coerce", 13, 2));
		dict.__setitem__("chr", (PyObject)new BuiltinFunctions("chr", 0, 1));
		dict.__setitem__("cmp", (PyObject)new BuiltinFunctions("cmp", 6, 2));
		dict.__setitem__("globals", (PyObject)new BuiltinFunctions("globals", 4, 0));
		dict.__setitem__("hash", (PyObject)new BuiltinFunctions("hash", 5, 1));
		dict.__setitem__("id", (PyObject)new BuiltinFunctions("id", 11, 1));
		dict.__setitem__("isinstance", (PyObject)new BuiltinFunctions("isinstance", 10, 2));
		dict.__setitem__("len", (PyObject)new BuiltinFunctions("len", 1, 1));
		dict.__setitem__("ord", (PyObject)new BuiltinFunctions("ord", 3, 1));
		dict.__setitem__("range", (PyObject)new BuiltinFunctions("range", 2, 1, 3));
		dict.__setitem__("sum", (PyObject)new BuiltinFunctions("sum", 12, 1, 2));
		dict.__setitem__("unichr", (PyObject)new BuiltinFunctions("unichr", 6, 1));
		dict.__setitem__("delattr", (PyObject)new BuiltinFunctions("delattr", 15, 2));
		dict.__setitem__("dir", (PyObject)new BuiltinFunctions("dir", 16, 0, 1));
		dict.__setitem__("divmod", (PyObject)new BuiltinFunctions("divmod", 17, 2));
		dict.__setitem__("eval", (PyObject)new BuiltinFunctions("eval", 18, 1, 3));
		dict.__setitem__("execfile", (PyObject)new BuiltinFunctions("execfile", 19, 1, 3));
		dict.__setitem__("filter", (PyObject)new BuiltinFunctions("filter", 20, 2));
		dict.__setitem__("getattr", (PyObject)new BuiltinFunctions("getattr", 21, 2, 3));
		dict.__setitem__("hasattr", (PyObject)new BuiltinFunctions("hasattr", 22, 2));
		dict.__setitem__("hex", (PyObject)new BuiltinFunctions("hex", 23, 1));
		dict.__setitem__("input", (PyObject)new BuiltinFunctions("input", 24, 0, 1));
		dict.__setitem__("intern", (PyObject)new BuiltinFunctions("intern", 25, 1));
		dict.__setitem__("issubclass", (PyObject)new BuiltinFunctions("issubclass", 26, 2));
		dict.__setitem__("iter", (PyObject)new BuiltinFunctions("iter", 27, 1, 2));
		dict.__setitem__("locals", (PyObject)new BuiltinFunctions("locals", 28, 0));
		dict.__setitem__("map", (PyObject)new BuiltinFunctions("map", 29, 2, -1));
		dict.__setitem__("max", (PyObject)new MaxFunction());
		dict.__setitem__("min", (PyObject)new MinFunction());
		dict.__setitem__("oct", (PyObject)new BuiltinFunctions("oct", 32, 1));
		dict.__setitem__("pow", (PyObject)new BuiltinFunctions("pow", 33, 2, 3));
		dict.__setitem__("raw_input", (PyObject)new BuiltinFunctions("raw_input", 34, 0, 1));
		dict.__setitem__("reduce", (PyObject)new BuiltinFunctions("reduce", 35, 2, 3));
		dict.__setitem__("reload", (PyObject)new BuiltinFunctions("reload", 36, 1));
		dict.__setitem__("repr", (PyObject)new BuiltinFunctions("repr", 37, 1));
		dict.__setitem__("round", (PyObject)new RoundFunction());
		dict.__setitem__("setattr", (PyObject)new BuiltinFunctions("setattr", 39, 3));
		dict.__setitem__("vars", (PyObject)new BuiltinFunctions("vars", 41, 0, 1));
		dict.__setitem__("zip", (PyObject)new BuiltinFunctions("zip", 43, 0, -1));
		dict.__setitem__("compile", (PyObject)new CompileFunction());
		dict.__setitem__("open", (PyObject)new OpenFunction());
		dict.__setitem__("reversed", (PyObject)new BuiltinFunctions("reversed", 45, 1));
		dict.__setitem__("__import__", (PyObject)new ImportFunction());
		dict.__setitem__("sorted", (PyObject)new SortedFunction());
		dict.__setitem__("all", (PyObject)new AllFunction());
		dict.__setitem__("any", (PyObject)new AnyFunction());
	}

	public static PyObject abs(PyObject o) {
		return o.__abs__();
	}

	public static PyObject apply(PyObject o) {
		return o.__call__();
	}

	public static PyObject apply(PyObject o, PyObject args) {
		return o.__call__(Py.make_array((PyObject)args));
	}

	public static PyObject apply(PyObject o, PyObject args, PyDictionary kws) {
		ConcurrentMap concurrentMap = kws.getMap();
		if (concurrentMap.size() > 0) {
			Iterator iterator = concurrentMap.keySet().iterator();
			Iterator table = concurrentMap.values().iterator();
			int ik = concurrentMap.size();
			String[] iv = new String[ik];
			PyObject[] n = Py.make_array((PyObject)args);
			PyObject[] aargs = new PyObject[ik + n.length];
			System.arraycopy(n, 0, aargs, 0, n.length);
			int offset = n.length;
			for (int i = 0; i < ik; ++i) {
				void kw;
				PyObject name = (PyObject)kw.next();
				if (name.getClass() != PyString.class) {
					throw Py.TypeError((String)String.format("keywords must be strings", new Object[0]));
				}
				iv[i] = ((PyString)name).internedString();
				aargs[i + offset] = (PyObject)table.next();
			}
			return o.__call__(aargs, iv);
		}
		return __builtin__.apply(o, args);
	}

	public static boolean callable(PyObject obj) {
		return obj.isCallable();
	}

	public static int unichr(int i) {
		if (i < 0 || i > 1114111) {
			throw Py.ValueError((String)"unichr() arg not in range(0x110000)");
		}
		return i;
	}

	public static char chr(int i) {
		if (i < 0 || i > 255) {
			throw Py.ValueError((String)"chr() arg not in range(256)");
		}
		return (char)i;
	}

	public static int cmp(PyObject x, PyObject y) {
		return x._cmp(y);
	}

	public static PyTuple coerce(PyObject o1, PyObject o2) {
		PyObject[] result = o1._coerce(o2);
		if (result != null) {
			return new PyTuple(result);
		}
		throw Py.TypeError((String)"number coercion failed");
	}

	public static void delattr(PyObject obj, PyObject name) {
		obj.__delattr__(__builtin__.asName(name, "delattr"));
	}

	public static PyObject dir(PyObject o) {
		PyList ret = (PyList)o.__dir__();
		ret.sort();
		return ret;
	}

	public static PyObject dir() {
		PyList retObj;
		PyObject l = __builtin__.locals();
		PyObject pyObject = l.invoke("keys");
		try {
			retObj = (PyList)pyObject;
		}
		catch (ClassCastException e) {
			throw Py.TypeError((String)String.format("Expected keys() to be a list, not '%s'", ret.getType().fastGetName()));
		}
		retObj.sort();
		return retObj;
	}

	public static PyObject divmod(PyObject x, PyObject y) {
		return x._divmod(y);
	}

	private static boolean isMappingType(PyObject o) {
		return o == null || o == Py.None || o.isMappingType();
	}

	private static void verify_mappings(PyObject globals, PyObject locals) {
		if (!__builtin__.isMappingType(globals)) {
			throw Py.TypeError((String)"globals must be a mapping");
		}
		if (!__builtin__.isMappingType(locals)) {
			throw Py.TypeError((String)"locals must be a mapping");
		}
	}

	public static PyObject eval(PyObject o, PyObject globals, PyObject locals) {
		PyCode code;
		__builtin__.verify_mappings(globals, locals);
		if (o instanceof PyCode) {
			code = (PyCode)o;
		} else if (o instanceof PyString) {
			code = (PyCode)CompileFunction.compile((PyObject)o, (String)"<string>", (String)"eval");
		} else {
			throw Py.TypeError((String)"eval: argument 1 must be string or code object");
		}
		return Py.runCode((PyCode)code, (PyObject)locals, (PyObject)globals);
	}

	public static PyObject eval(PyObject o, PyObject globals) {
		return __builtin__.eval(o, globals, globals);
	}

	public static PyObject eval(PyObject o) {
		if (o instanceof PyBaseCode && ((PyBaseCode)o).hasFreevars()) {
			throw Py.TypeError((String)"code object passed to eval() may not contain free variables");
		}
		return __builtin__.eval(o, null, null);
	}

	public static void execfile(String name, PyObject globals, PyObject locals) {
		__builtin__.execfile_flags(name, globals, locals, Py.getCompilerFlags());
	}

	public static void execfile_flags(String name, PyObject globals, PyObject locals, CompilerFlags cflags) {
		PyCode code;
		FileInputStream file;
		__builtin__.verify_mappings(globals, locals);
		try {
			file = new FileInputStream((File)new RelativeFile(name));
		}
		catch (FileNotFoundException e) {
			throw Py.IOError((IOException)e);
		}
		try {
			code = Py.compile_flags((InputStream)file, (String)name, (CompileMode)CompileMode.exec, (CompilerFlags)cflags);
		}
		finally {
			try {
				file.close();
			}
			catch (IOException e) {
				throw Py.IOError((IOException)e);
			}
		}
		Py.runCode((PyCode)code, (PyObject)locals, (PyObject)globals);
	}

	public static void execfile_flags(String name, PyObject globals, PyObject locals, CompilerFlags cflags, CurrentLine line) {
		PyCode code;
		FileInputStream file;
		__builtin__.verify_mappings(globals, locals);
		try {
			file = new FileInputStream((File)new RelativeFile(name));
		}
		catch (FileNotFoundException e) {
			throw Py.IOError((IOException)e);
		}
		try {
			code = Py.compile_flags((InputStream)file, (String)name, (CompileMode)CompileMode.exec, (CompilerFlags)cflags);
		}
		finally {
			try {
				file.close();
			}
			catch (IOException e) {
				throw Py.IOError((IOException)e);
			}
		}
		Py.runCode((PyCode)code, (PyObject)locals, (PyObject)globals, (CurrentLine) line);
	}

	public static void execfile(String name, PyObject globals) {
		__builtin__.execfile(name, globals, globals);
	}

	public static void execfile(String name) {
		__builtin__.execfile(name, null, null);
	}

	public static PyObject filter(PyObject func, PyObject seq) {
		if (seq instanceof PyString) {
			return __builtin__.filterBaseString(func, (PyBaseString)((PyString)seq), seq instanceof PyUnicode ? PyUnicode.TYPE : PyString.TYPE);
		}
		if (seq instanceof PyTuple) {
			return __builtin__.filterTuple(func, (PyTuple)seq);
		}
		PyList list = new PyList();
		for (PyObject item : seq.asIterable()) {
			if (func == PyBoolean.TYPE || func == Py.None ? !item.__nonzero__() : !func.__call__(item).__nonzero__()) continue;
			list.append(item);
		}
		return list;
	}

	public static PyObject filterBaseString(PyObject func, PyBaseString seq, PyType stringType) {
		if (func == Py.None && seq.getType() == stringType) {
			return seq;
		}
		StringBuilder builder = new StringBuilder();
		for (PyObject item : seq.asIterable()) {
			if (func == Py.None) {
				if (!item.__nonzero__()) {
					continue;
				}
			} else if (!func.__call__(item).__nonzero__()) continue;
			if (!Py.isInstance((PyObject)item, (PyObject)stringType)) {
				String name = stringType.fastGetName();
				throw Py.TypeError((String)String.format("can't filter %s to %s: __getitem__ returned different type", name, name));
			}
			builder.append(item.toString());
		}
		String result = builder.toString();
		return stringType == PyString.TYPE ? new PyString(result) : new PyUnicode(result);
	}

	public static PyObject filterTuple(PyObject func, PyTuple seq) {
		int len = seq.size();
		if (len == 0) {
			if (seq.getType() != PyTuple.TYPE) {
				return Py.EmptyTuple;
			}
			return seq;
		}
		PyList list = new PyList();
		int n = 0;
		while (n < len) {
			void item;
			PyObject i = seq.__finditem__(n);
			if (!(func == Py.None ? !i.__nonzero__() : !func.__call__(i).__nonzero__())) {
				list.append(i);
			}
			++item;
		}
		return PyTuple.fromIterable((PyObject)list);
	}

	public static PyObject getattr(PyObject obj, PyObject name) {
		return __builtin__.getattr(obj, name, null);
	}

	public static PyObject getattr(PyObject obj, PyObject nameObj, PyObject def) {
		String name = __builtin__.asName(nameObj, "getattr");
		PyObject result = null;
		PyException attributeError = null;
		try {
			result = obj.__findattr_ex__(name);
		}
		catch (PyException pye) {
			if (!pye.match(Py.AttributeError)) {
				throw pye;
			}
			attributeError = pye;
		}
		if (result != null) {
			return result;
		}
		if (def != null) {
			return def;
		}
		if (attributeError == null) {
			obj.noAttributeError(name);
		}
		throw attributeError;
	}

	public static PyObject globals() {
		return Py.getFrame().f_globals;
	}

	public static boolean hasattr(PyObject obj, PyObject nameObj) {
		String name = __builtin__.asName(nameObj, "hasattr");
		try {
			return obj.__findattr__(name) != null;
		}
		catch (PyException pye) {
			return false;
		}
	}

	public static PyInteger hash(PyObject o) {
		return o.__hash__();
	}

	public static PyString hex(PyObject o) {
		return o.__hex__();
	}

	public static long id(PyObject o) {
		return Py.id((PyObject)o);
	}

	public static PyObject input(PyObject prompt) {
		String line = __builtin__.raw_input(prompt);
		return __builtin__.eval((PyObject)new PyString(line));
	}

	public static PyObject input() {
		return __builtin__.input((PyObject)new PyString(""));
	}

	public static PyString intern(PyObject obj) {
		if (!(obj instanceof PyString) || obj instanceof PyUnicode) {
			throw Py.TypeError((String)("intern() argument 1 must be string, not " + obj.getType().fastGetName()));
		}
		if (obj.getType() != PyString.TYPE) {
			throw Py.TypeError((String)"can't intern subclass of string");
		}
		PyString s = (PyString)obj;
		String istring = s.internedString();
		PyObject ret = internedStrings.__finditem__(istring);
		if (ret != null) {
			return (PyString)ret;
		}
		internedStrings.__setitem__(istring, (PyObject)s);
		return s;
	}

	public static boolean isinstance(PyObject obj, PyObject cls) {
		return Py.isInstance((PyObject)obj, (PyObject)cls);
	}

	public static boolean issubclass(PyObject derived, PyObject cls) {
		return Py.isSubClass((PyObject)derived, (PyObject)cls);
	}

	public static PyObject iter(PyObject obj) {
		return obj.__iter__();
	}

	public static PyObject iter(PyObject callable, PyObject sentinel) {
		return new PyCallIter(callable, sentinel);
	}

	public static int len(PyObject obj) {
		return obj.__len__();
	}

	public static PyObject locals() {
		return Py.getFrame().getLocals();
	}

	public static PyObject map(PyObject[] argstar) {
		int iters;
		int n = argstar.length - 1;
		if (n < 1) {
			throw Py.TypeError((String)"map requires at least two arguments");
		}
		PyObject pyObject = argstar[0];
		PyList f = new PyList();
		PyObject[] list = new PyObject[n];
		PyObject[] args = new PyObject[n];
		for (iters = 0; iters < n; ++iters) {
			args[iters] = Py.iter((PyObject)argstar[iters + 1], (String)("argument " + (iters + 1) + " to map() must support iteration"));
		}
		do {
			void element;
			iters = 0;
			for (int any_items = 0; any_items < n; ++any_items) {
				PyObject j = args[any_items].__iternext__();
				if (j != null) {
					list[any_items] = j;
					iters = 1;
					continue;
				}
				list[any_items] = Py.None;
			}
			if (iters == 0) break;
			if (element == Py.None) {
				if (n == 1) {
					f.append(list[0]);
					continue;
				}
				f.append((PyObject)new PyTuple((PyObject[])list.clone()));
				continue;
			}
			f.append(element.__call__(list));
		} while (true);
		return f;
	}

	public static PyString oct(PyObject o) {
		return o.__oct__();
	}

	public static final int ord(PyObject c) {
		int x;
		void length;
		PyString pyString = (PyString)c;
		if (pyString instanceof PyUnicode) {
			x = pyString.getString().codePointCount(0, pyString.getString().length());
			if (x == 1) {
				return length.getString().codePointAt(0);
			}
		} else {
			x = length.getString().length();
			if (x == 1) {
				return length.getString().charAt(0);
			}
		}
		throw Py.TypeError((String)("ord() expected a character, but string of length " + x + " found"));
	}

	public static PyObject pow(PyObject x, PyObject y) {
		return x._pow(y);
	}

	private static boolean coerce(PyObject[] objs) {
		PyObject x = objs[0];
		PyObject y = objs[1];
		PyObject[] result = x._coerce(y);
		if (result != null) {
			objs[0] = result[0];
			objs[1] = result[1];
			return true;
		}
		result = y._coerce(x);
		if (result != null) {
			objs[0] = result[1];
			objs[1] = result[0];
			return true;
		}
		return false;
	}

	public static PyObject pow(PyObject x, PyObject y, PyObject z) {
		PyObject result;
		if (z == Py.None) {
			return __builtin__.pow(x, y);
		}
		PyObject[] tmp = new PyObject[]{x, y};
		if (__builtin__.coerce(tmp)) {
			x = tmp[0];
			y = tmp[1];
			tmp[1] = z;
			if (__builtin__.coerce(tmp)) {
				x = tmp[0];
				z = tmp[1];
				tmp[0] = y;
				if (__builtin__.coerce(tmp)) {
					z = tmp[1];
					y = tmp[0];
				}
			}
		} else {
			tmp[1] = z;
			if (__builtin__.coerce(tmp)) {
				x = tmp[0];
				z = tmp[1];
				tmp[0] = y;
				if (__builtin__.coerce(tmp)) {
					y = tmp[0];
					z = tmp[1];
					tmp[1] = x;
					if (__builtin__.coerce(tmp)) {
						x = tmp[1];
						y = tmp[0];
					}
				}
			}
		}
		if ((result = x.__pow__(y, z)) != null) {
			return result;
		}
		throw Py.TypeError((String)String.format("unsupported operand type(s) for pow(): '%.100s', '%.100s', '%.100s'", x.getType().fastGetName(), y.getType().fastGetName(), z.getType().fastGetName()));
	}

	public static PyObject range(PyObject start, PyObject stop, PyObject step) {
		void range;
		int ilow = 0;
		int ihigh = 0;
		int istep = 1;
		try {
			ilow = start.asInt();
			ihigh = stop.asInt();
			istep = step.asInt();
		}
		catch (PyException var6_6) {
			return __builtin__.handleRangeLongs(start, stop, step);
		}
		if (istep == 0) {
			throw Py.ValueError((String)"range() step argument must not be zero");
		}
		int pye = istep > 0 ? PyXRange.getLenOfRange((int)ilow, (int)ihigh, (int)istep) : PyXRange.getLenOfRange((int)ihigh, (int)ilow, (int)(- istep));
		if (pye < 0) {
			throw Py.OverflowError((String)"range() result has too many items");
		}
		PyObject[] n = new PyObject[pye];
		int i = 0;
		while (i < range) {
			n[i] = Py.newInteger((int)ilow);
			++i;
			ilow+=istep;
		}
		return new PyList(n);
	}

	public static PyObject range(PyObject n) {
		return __builtin__.range((PyObject)Py.Zero, n, (PyObject)Py.One);
	}

	public static PyObject range(PyObject start, PyObject stop) {
		return __builtin__.range(start, stop, (PyObject)Py.One);
	}

	private static PyObject handleRangeLongs(PyObject ilow, PyObject ihigh, PyObject istep) {
		if (!(ilow instanceof PyInteger || ilow instanceof PyLong)) {
			throw Py.TypeError((String)String.format("range() integer start argument expected, got %s.", ilow.getType().fastGetName()));
		}
		if (!(ihigh instanceof PyInteger || ihigh instanceof PyLong)) {
			throw Py.TypeError((String)String.format("range() integer end argument expected, got %s.", ihigh.getType().fastGetName()));
		}
		if (!(istep instanceof PyInteger || istep instanceof PyLong)) {
			throw Py.TypeError((String)String.format("range() integer step argument expected, got %s.", istep.getType().fastGetName()));
		}
		int n = istep._cmp((PyObject)Py.Zero);
		if (n == 0) {
			throw Py.ValueError((String)"range() step argument must not be zero");
		}
		int cmpResult = n > 0 ? __builtin__.getLenOfRangeLongs(ilow, ihigh, istep) : __builtin__.getLenOfRangeLongs(ihigh, ilow, istep.__neg__());
		if (cmpResult < 0) {
			throw Py.OverflowError((String)"range() result has too many items");
		}
		PyObject[] range = new PyObject[cmpResult];
		for (int i = 0; i < cmpResult; ++i) {
			range[i] = ilow.__long__();
			ilow = ilow.__add__(istep);
		}
		return new PyList(range);
	}

	private static int getLenOfRangeLongs(PyObject lo, PyObject hi, PyObject step) {
		if (lo._cmp(hi) >= 0) {
			return 0;
		}
		try {
			PyObject diff = hi.__sub__(lo).__sub__((PyObject)Py.One);
			PyObject n = diff.__floordiv__(step).__add__((PyObject)Py.One);
			return n.asInt();
		}
		catch (PyException pye) {
			return -1;
		}
	}

	private static PyString readline(PyObject file) {
		if (file instanceof PyFile) {
			return ((PyFile)file).readline();
		}
		PyObject ret = file.invoke("readline");
		if (!(ret instanceof PyString)) {
			throw Py.TypeError((String)"object.readline() returned non-string");
		}
		return (PyString)ret;
	}

	public static String raw_input(PyObject prompt, PyObject file) {
		PyObject stdout = Py.getSystemState().stdout;
		if (stdout instanceof PyAttributeDeleted) {
			throw Py.RuntimeError((String)"[raw_]input: lost sys.stdout");
		}
		Py.print((PyObject)stdout, (PyObject)prompt);
		String data = __builtin__.readline(file).toString();
		if (data.endsWith("\n")) {
			return data.substring(0, data.length() - 1);
		}
		if (data.length() == 0) {
			throw Py.EOFError((String)"raw_input()");
		}
		return data;
	}

	public static String raw_input(PyObject prompt) {
		PyObject stdin = Py.getSystemState().stdin;
		if (stdin instanceof PyAttributeDeleted) {
			throw Py.RuntimeError((String)"[raw_]input: lost sys.stdin");
		}
		return __builtin__.raw_input(prompt, stdin);
	}

	public static String raw_input() {
		return __builtin__.raw_input((PyObject)new PyString(""));
	}

	public static PyObject reduce(PyObject f, PyObject l, PyObject z) {
		PyObject item;
		PyObject result = z;
		PyObject iter = Py.iter((PyObject)l, (String)"reduce() arg 2 must support iteration");
		while ((item = iter.__iternext__()) != null) {
			if (result == null) {
				result = item;
				continue;
			}
			result = f.__call__(result, item);
		}
		if (result == null) {
			throw Py.TypeError((String)"reduce of empty sequence with no initial value");
		}
		return result;
	}

	public static PyObject reduce(PyObject f, PyObject l) {
		return __builtin__.reduce(f, l, null);
	}

	public static PyObject reload(PyModule o) {
		return imp.reload((PyModule)o);
	}

	public static PyObject reload(PySystemState o) {
		o.reload();
		return o;
	}

	public static PyString repr(PyObject o) {
		return o.__repr__();
	}

	public static void setattr(PyObject obj, PyObject name, PyObject value) {
		obj.__setattr__(__builtin__.asName(name, "setattr"), value);
	}

	public static PyObject sum(PyObject seq, PyObject result) {
		if (result instanceof PyString) {
			throw Py.TypeError((String)"sum() can't sum strings [use ''.join(seq) instead]");
		}
		for (PyObject item : seq.asIterable()) {
			result = result._add(item);
		}
		return result;
	}

	public static PyObject reversed(PyObject seq) {
		if (seq.__findattr__("__getitem__") != null && seq.__findattr__("__len__") != null && seq.__findattr__("keys") == null) {
			return new PyReversedIterator(seq);
		}
		throw Py.TypeError((String)"argument to reversed() must be a sequence");
	}

	public static PyObject sum(PyObject seq) {
		return __builtin__.sum(seq, (PyObject)Py.Zero);
	}

	public static PyType type(PyObject o) {
		return o.getType();
	}

	public static PyObject vars() {
		return __builtin__.locals();
	}

	public static PyObject vars(PyObject o) {
		try {
			return o.__getattr__("__dict__");
		}
		catch (PyException e) {
			if (e.match(Py.AttributeError)) {
				throw Py.TypeError((String)"vars() argument must have __dict__ attribute");
			}
			throw e;
		}
	}

	public static PyObject zip() {
		return new PyList();
	}

	public static PyObject zip(PyObject[] argstar) {
		int itemsize = argstar.length;
		PyObject[] iters = new PyObject[itemsize];
		for (int j = 0; j < itemsize; ++j) {
			PyObject iter = argstar[j].__iter__();
			if (iter == null) {
				throw Py.TypeError((String)("zip argument #" + (j + 1) + " must support iteration"));
			}
			iters[j] = iter;
		}
		PyList ret = new PyList();
		int i = 0;
		do {
			PyObject[] next = new PyObject[itemsize];
			int n = 0;
			while (n < itemsize) {
				PyObject j2;
				void item;
				try {
					j2 = iters[n].__iternext__();
				}
				catch (PyException e) {
					if (e.match(Py.StopIteration)) {
						return ret;
					}
					throw e;
				}
				if (j2 == null) {
					return ret;
				}
				next[item] = j2;
				++item;
			}
			ret.append((PyObject)new PyTuple(next));
			++i;
		} while (true);
	}

	public static PyObject __import__(String name) {
		return __builtin__.__import__(name, null, null, null, -1);
	}

	public static PyObject __import__(String name, PyObject globals) {
		return __builtin__.__import__(name, globals, null, null, -1);
	}

	public static PyObject __import__(String name, PyObject globals, PyObject locals) {
		return __builtin__.__import__(name, globals, locals, null, -1);
	}

	public static PyObject __import__(String name, PyObject globals, PyObject locals, PyObject fromlist) {
		return __builtin__.__import__(name, globals, locals, fromlist, -1);
	}

	public static PyObject __import__(String name, PyObject globals, PyObject locals, PyObject fromlist, int level) {
		PyFrame frame = Py.getFrame();
		PyObject builtins = frame != null && frame.f_builtins != null ? frame.f_builtins : PySystemState.builtins;
		PyObject __import__ = builtins.__finditem__("__import__");
		if (__import__ == null) {
			return null;
		}
		PyObject[] args = level < 0 ? new PyObject[]{Py.newString((String)name), globals, locals, fromlist} : new PyObject[]{Py.newString((String)name), globals, locals, fromlist, Py.newInteger((int)level)};
		PyObject module = __import__.__call__(args);
		return module;
	}

	private static String asName(PyObject name, String function) {
		if (name instanceof PyUnicode) {
			return ((PyUnicode)name).encode().intern();
		}
		if (name instanceof PyString) {
			return ((PyString)name).internedString();
		}
		throw Py.TypeError((String)(function + "(): attribute name must be string"));
	}
}
