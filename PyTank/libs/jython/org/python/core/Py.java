/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  org.python.antlr.base.mod
 *  org.python.constantine.Constant
 *  org.python.constantine.platform.Errno
 *  org.python.core.CodeBootstrap
 *  org.python.core.CodeLoader
 *  org.python.core.CompileMode
 *  org.python.core.CompilerFacade
 *  org.python.core.CompilerFlags
 *  org.python.core.FixedFileWrapper
 *  org.python.core.IdImpl
 *  org.python.core.JavaCode
 *  org.python.core.JavaFunc
 *  org.python.core.Options
 *  org.python.core.ParserFacade
 *  org.python.core.PyBaseCode
 *  org.python.core.PyBoolean
 *  org.python.core.PyBuiltinCallable
 *  org.python.core.PyClass
 *  org.python.core.PyCode
 *  org.python.core.PyComplex
 *  org.python.core.PyDataDescr
 *  org.python.core.PyDictionary
 *  org.python.core.PyException
 *  org.python.core.PyFile
 *  org.python.core.PyFloat
 *  org.python.core.PyFrame
 *  org.python.core.PyFrozenSet
 *  org.python.core.PyFunctionTable
 *  org.python.core.PyGenerator
 *  org.python.core.PyInstance
 *  org.python.core.PyInteger
 *  org.python.core.PyJavaType
 *  org.python.core.PyLong
 *  org.python.core.PyObject
 *  org.python.core.PyProxy
 *  org.python.core.PyRunnable
 *  org.python.core.PyRunnableBootstrap
 *  org.python.core.PySequenceList
 *  org.python.core.PyString
 *  org.python.core.PyStringMap
 *  org.python.core.PySystemState
 *  org.python.core.PyTableCode
 *  org.python.core.PyTraceback
 *  org.python.core.PyTuple
 *  org.python.core.PyType
 *  org.python.core.PyUnicode
 *  org.python.core.StdoutWrapper
 *  org.python.core.ThreadState
 *  org.python.core.ThreadStateMapping
 *  org.python.core.adapter.ClassicPyObjectAdapter
 *  org.python.core.adapter.ExtensiblePyObjectAdapter
 *  org.python.core.imp
 *  org.python.modules.posix.PosixModule
 *  org.python.util.Generic
 */
package org.python.core;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import org.python.antlr.base.mod;
import org.python.constantine.Constant;
import org.python.constantine.platform.Errno;
import org.python.core.CodeBootstrap;
import org.python.core.CodeLoader;
import org.python.core.CompileMode;
import org.python.core.CompilerFacade;
import org.python.core.CompilerFlags;
import org.python.core.FixedFileWrapper;
import org.python.core.IdImpl;
import org.python.core.JavaCode;
import org.python.core.JavaFunc;
import org.python.core.Options;
import org.python.core.ParserFacade;
import org.python.core.PyBaseCode;
import org.python.core.PyBoolean;
import org.python.core.PyBuiltinCallable;
import org.python.core.PyClass;
import org.python.core.PyCode;
import org.python.core.PyComplex;
import org.python.core.PyDataDescr;
import org.python.core.PyDictionary;
import org.python.core.PyException;
import org.python.core.PyFile;
import org.python.core.PyFloat;
import org.python.core.PyFrame;
import org.python.core.PyFrozenSet;
import org.python.core.PyFunctionTable;
import org.python.core.PyGenerator;
import org.python.core.PyInstance;
import org.python.core.PyInteger;
import org.python.core.PyJavaType;
import org.python.core.PyLong;
import org.python.core.PyObject;
import org.python.core.PyProxy;
import org.python.core.PyRunnable;
import org.python.core.PyRunnableBootstrap;
import org.python.core.PySequenceList;
import org.python.core.PyString;
import org.python.core.PyStringMap;
import org.python.core.PySystemState;
import org.python.core.PyTableCode;
import org.python.core.PyTraceback;
import org.python.core.PyTuple;
import org.python.core.PyType;
import org.python.core.PyUnicode;
import org.python.core.StdoutWrapper;
import org.python.core.ThreadState;
import org.python.core.ThreadStateMapping;
import org.python.core.__builtin__;
import org.python.core.adapter.ClassicPyObjectAdapter;
import org.python.core.adapter.ExtensiblePyObjectAdapter;
import org.python.core.imp;
import org.python.modules.posix.PosixModule;
import org.python.util.Generic;
import org.python.util.CurrentLine;
/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public final class Py {
	public static PyObject None;
	public static PyObject Ellipsis;
	public static PyObject NotImplemented;
	public static String[] NoKeywords;
	public static PyObject[] EmptyObjects;
	public static PyFrozenSet EmptyFrozenSet;
	public static PyTuple EmptyTuple;
	public static PyInteger Zero;
	public static PyInteger One;
	public static PyBoolean False;
	public static PyBoolean True;
	public static PyString EmptyString;
	public static PyString Newline;
	public static PyString Space;
	public static long TPFLAGS_HEAPTYPE;
	public static long TPFLAGS_BASETYPE;
	static final Set<Class<?>> BOOTSTRAP_TYPES;
	public static Object NoConversion;
	public static PyObject OSError;
	public static PyObject NotImplementedError;
	public static PyObject EnvironmentError;
	public static PyObject OverflowError;
	public static PyObject RuntimeError;
	public static PyObject KeyboardInterrupt;
	public static PyObject FloatingPointError;
	public static PyObject SyntaxError;
	public static PyObject IndentationError;
	public static PyObject TabError;
	public static PyObject AttributeError;
	public static PyObject IOError;
	public static PyObject KeyError;
	public static PyObject AssertionError;
	public static PyObject TypeError;
	public static PyObject ReferenceError;
	public static PyObject SystemError;
	public static PyObject IndexError;
	public static PyObject ZeroDivisionError;
	public static PyObject NameError;
	public static PyObject UnboundLocalError;
	public static PyObject SystemExit;
	public static PyObject StopIteration;
	public static PyObject GeneratorExit;
	public static PyObject ImportError;
	public static PyObject ValueError;
	public static PyObject UnicodeError;
	public static PyObject UnicodeTranslateError;
	public static PyObject UnicodeDecodeError;
	public static PyObject UnicodeEncodeError;
	public static PyObject EOFError;
	public static PyObject MemoryError;
	public static PyObject ArithmeticError;
	public static PyObject LookupError;
	public static PyObject StandardError;
	public static PyObject Exception;
	public static PyObject BaseException;
	public static PyObject Warning;
	public static PyObject UserWarning;
	public static PyObject DeprecationWarning;
	public static PyObject PendingDeprecationWarning;
	public static PyObject SyntaxWarning;
	public static PyObject RuntimeWarning;
	public static PyObject FutureWarning;
	public static PyObject ImportWarning;
	public static PyObject UnicodeWarning;
	private static PyObject warnings_mod;
	public static PyObject JavaError;
	private static final PyInteger[] integerCache;
	public static volatile PySystemState defaultSystemState;
	private static boolean syspathJavaLoaderRestricted;
	private static final ThreadStateMapping threadStateMapping;
	public static StdoutWrapper stderr;
	static StdoutWrapper stdout;
	private static final PyString[] letters;
	private static ExtensiblePyObjectAdapter adapter;
	private static int nameindex;
	private static IdImpl idimpl;
	public static final int ERROR = -1;
	public static final int WARNING = 0;
	public static final int MESSAGE = 1;
	public static final int COMMENT = 2;
	public static final int DEBUG = 3;

	public static PyException OSError(String message) {
		return new PyException(OSError, message);
	}

	public static PyException OSError(IOException ioe) {
		return Py.fromIOException(ioe, OSError);
	}

	public static PyException OSError(Constant errno) {
		int value = errno.value();
		PyTuple args = new PyTuple(new PyObject[]{Py.newInteger(value), PosixModule.strerror((int)value)});
		return new PyException(OSError, (PyObject)args);
	}

	public static PyException OSError(Constant errno, PyObject filename) {
		int value = errno.value();
		PyTuple args = new PyTuple(new PyObject[]{Py.newInteger(value), PosixModule.strerror((int)value), filename});
		return new PyException(OSError, (PyObject)args);
	}

	@Deprecated
		public static PyException OSError(Constant errno, String filename) {
			return Py.OSError(errno, (PyObject)Py.newString(filename));
		}

	public static PyException NotImplementedError(String message) {
		return new PyException(NotImplementedError, message);
	}

	public static PyException EnvironmentError(String message) {
		return new PyException(EnvironmentError, message);
	}

	public static PyException OverflowError(String message) {
		return new PyException(OverflowError, message);
	}

	public static PyException RuntimeError(String message) {
		return new PyException(RuntimeError, message);
	}

	public static PyException FloatingPointError(String message) {
		return new PyException(FloatingPointError, message);
	}

	public static PyException SyntaxError(String message) {
		return new PyException(SyntaxError, message);
	}

	public static PyException AttributeError(String message) {
		return new PyException(AttributeError, message);
	}

	public static PyException IOError(IOException ioe) {
		return Py.fromIOException(ioe, IOError);
	}

	public static PyException IOError(String message) {
		return new PyException(IOError, message);
	}

	public static PyException IOError(Constant errno) {
		int value = errno.value();
		PyTuple args = new PyTuple(new PyObject[]{Py.newInteger(value), PosixModule.strerror((int)value)});
		return new PyException(IOError, (PyObject)args);
	}

	public static PyException IOError(Constant errno, PyObject filename) {
		int value = errno.value();
		PyTuple args = new PyTuple(new PyObject[]{Py.newInteger(value), PosixModule.strerror((int)value), filename});
		return new PyException(IOError, (PyObject)args);
	}

	@Deprecated
		public static PyException IOError(Constant errno, String filename) {
			return Py.IOError(errno, (PyObject)Py.newString(filename));
		}

	private static PyException fromIOException(IOException ioe, PyObject err) {
		String message = ioe.getMessage();
		if (message == null) {
			message = ioe.getClass().getName();
		}
		if (ioe instanceof FileNotFoundException) {
			PyTuple args = new PyTuple(new PyObject[]{Py.newInteger(Errno.ENOENT.value()), Py.newString("File not found - " + message)});
			return new PyException(err, (PyObject)args);
		}
		return new PyException(err, message);
	}

	public static PyException KeyError(String message) {
		return new PyException(KeyError, message);
	}

	public static PyException KeyError(PyObject key) {
		return new PyException(KeyError, key);
	}

	public static PyException AssertionError(String message) {
		return new PyException(AssertionError, message);
	}

	public static PyException TypeError(String message) {
		return new PyException(TypeError, message);
	}

	public static PyException ReferenceError(String message) {
		return new PyException(ReferenceError, message);
	}

	public static PyException SystemError(String message) {
		return new PyException(SystemError, message);
	}

	public static PyException IndexError(String message) {
		return new PyException(IndexError, message);
	}

	public static PyException ZeroDivisionError(String message) {
		return new PyException(ZeroDivisionError, message);
	}

	public static PyException NameError(String message) {
		return new PyException(NameError, message);
	}

	public static PyException UnboundLocalError(String message) {
		return new PyException(UnboundLocalError, message);
	}

	static void maybeSystemExit(PyException exc) {
		if (exc.match(SystemExit)) {
			PyObject value = exc.value;
			if (PyException.isExceptionInstance((PyObject)exc.value)) {
				value = value.__findattr__("code");
			}
			Py.getSystemState().callExitFunc();
			if (value instanceof PyInteger) {
				System.exit(((PyInteger)value).getValue());
			} else {
				if (value != None) {
					try {
						Py.println(value);
						System.exit(1);
					}
					catch (Throwable t) {
						// empty catch block
					}
				}
				System.exit(0);
			}
		}
	}

	public static PyException StopIteration(String message) {
		return new PyException(StopIteration, message);
	}

	public static PyException GeneratorExit(String message) {
		return new PyException(GeneratorExit, message);
	}

	public static PyException ImportError(String message) {
		return new PyException(ImportError, message);
	}

	public static PyException ValueError(String message) {
		return new PyException(ValueError, message);
	}

	public static PyException UnicodeError(String message) {
		return new PyException(UnicodeError, message);
	}

	public static PyException UnicodeTranslateError(String object, int start, int end, String reason) {
		return new PyException(UnicodeTranslateError, (PyObject)new PyTuple(new PyObject[]{new PyString(object), new PyInteger(start), new PyInteger(end), new PyString(reason)}));
	}

	public static PyException UnicodeDecodeError(String encoding, String object, int start, int end, String reason) {
		return new PyException(UnicodeDecodeError, (PyObject)new PyTuple(new PyObject[]{new PyString(encoding), new PyString(object), new PyInteger(start), new PyInteger(end), new PyString(reason)}));
	}

	public static PyException UnicodeEncodeError(String encoding, String object, int start, int end, String reason) {
		return new PyException(UnicodeEncodeError, (PyObject)new PyTuple(new PyObject[]{new PyString(encoding), new PyUnicode(object), new PyInteger(start), new PyInteger(end), new PyString(reason)}));
	}

	public static PyException EOFError(String message) {
		return new PyException(EOFError, message);
	}

	public static void memory_error(OutOfMemoryError t) {
		if (Options.showJavaExceptions) {
			t.printStackTrace();
		}
	}

	public static PyException MemoryError(String message) {
		return new PyException(MemoryError, message);
	}

	public static void Warning(String message) {
		Py.warning(Warning, message);
	}

	public static void UserWarning(String message) {
		Py.warning(UserWarning, message);
	}

	public static void DeprecationWarning(String message) {
		Py.warning(DeprecationWarning, message);
	}

	public static void PendingDeprecationWarning(String message) {
		Py.warning(PendingDeprecationWarning, message);
	}

	public static void SyntaxWarning(String message) {
		Py.warning(SyntaxWarning, message);
	}

	public static void RuntimeWarning(String message) {
		Py.warning(RuntimeWarning, message);
	}

	public static void FutureWarning(String message) {
		Py.warning(FutureWarning, message);
	}

	public static void ImportWarning(String message) {
		Py.warning(ImportWarning, message);
	}

	public static void UnicodeWarning(String message) {
		Py.warning(UnicodeWarning, message);
	}

	private static PyObject importWarnings() {
		PyObject mod;
		if (warnings_mod != null) {
			return warnings_mod;
		}
		try {
			mod = __builtin__.__import__("warnings");
		}
		catch (PyException e) {
			if (e.match(ImportError)) {
				return null;
			}
			throw e;
		}
		warnings_mod = mod;
		return mod;
	}

	private static String warn_hcategory(PyObject category) {
		PyObject name = category.__findattr__("__name__");
		if (name != null) {
			return "[" + (Object)name + "]";
		}
		return "[warning]";
	}

	public static void warning(PyObject category, String message) {
		PyObject func = null;
		PyObject mod = Py.importWarnings();
		if (mod != null) {
			func = mod.__getattr__("warn");
		}
		if (func == null) {
			System.err.println(Py.warn_hcategory(category) + ": " + message);
			return;
		}
		func.__call__((PyObject)Py.newString(message), category);
	}

	public static void warning(PyObject category, String message, String filename, int lineno, String module, PyObject registry) {
		PyObject func = null;
		PyObject mod = Py.importWarnings();
		if (mod != null) {
			func = mod.__getattr__("warn_explicit");
		}
		if (func == null) {
			System.err.println(filename + ":" + lineno + ":" + Py.warn_hcategory(category) + ": " + message);
			return;
		}
		PyObject[] arrpyObject = new PyObject[6];
		arrpyObject[0] = Py.newString(message);
		arrpyObject[1] = category;
		arrpyObject[2] = Py.newString(filename);
		arrpyObject[3] = Py.newInteger(lineno);
		arrpyObject[4] = module == null ? None : Py.newString(module);
		arrpyObject[5] = registry;
		func.__call__(arrpyObject, NoKeywords);
	}

	public static PyException JavaError(Throwable t) {
		if (t instanceof PyException) {
			return (PyException)t;
		}
		if (t instanceof InvocationTargetException) {
			return Py.JavaError(((InvocationTargetException)t).getTargetException());
		}
		if (t instanceof StackOverflowError) {
			return Py.RuntimeError("maximum recursion depth exceeded");
		}
		if (t instanceof OutOfMemoryError) {
			Py.memory_error((OutOfMemoryError)t);
		}
		PyObject exc = PyJavaType.wrapJavaObject((Object)t);
		PyException pyex = new PyException((PyObject)exc.getType(), exc);
		pyex.initCause(t);
		return pyex;
	}

	private Py() {
	}

	public static <T> T tojava(PyObject o, Class<T> c) {
		Object obj = o.__tojava__(c);
		if (obj == NoConversion) {
			throw Py.TypeError("can't convert " + (Object)o.__repr__() + " to " + c.getName());
		}
		return (T)obj;
	}

	public static Object tojava(PyObject o, String s) {
		Class c = Py.findClass(s);
		if (c == null) {
			throw Py.TypeError("can't convert to: " + s);
		}
		return Py.tojava(o, c);
	}

	public static final PyInteger newInteger(int i) {
		if (i >= -100 && i < 900) {
			return integerCache[i + 100];
		}
		return new PyInteger(i);
	}

	public static PyObject newInteger(long i) {
		if (i < Integer.MIN_VALUE || i > Integer.MAX_VALUE) {
			return new PyLong(i);
		}
		return Py.newInteger((int)i);
	}

	public static PyLong newLong(String s) {
		return new PyLong(s);
	}

	public static PyLong newLong(BigInteger i) {
		return new PyLong(i);
	}

	public static PyLong newLong(int i) {
		return new PyLong((long)i);
	}

	public static PyLong newLong(long l) {
		return new PyLong(l);
	}

	public static PyComplex newImaginary(double v) {
		return new PyComplex(0.0, v);
	}

	public static PyFloat newFloat(float v) {
		return new PyFloat((double)v);
	}

	public static PyFloat newFloat(double v) {
		return new PyFloat(v);
	}

	public static PyString newString(char c) {
		return Py.makeCharacter(c);
	}

	public static PyString newString(String s) {
		return new PyString(s);
	}

	public static PyStringMap newStringMap() {
		if (!PyType.hasBuilder((Class)PyStringMap.class)) {
			BOOTSTRAP_TYPES.add(PyStringMap.class);
		}
		return new PyStringMap();
	}

	public static PyUnicode newUnicode(char c) {
		return (PyUnicode)Py.makeCharacter(c, true);
	}

	static PyObject newUnicode(int codepoint) {
		return Py.makeCharacter(codepoint, true);
	}

	public static PyUnicode newUnicode(String s) {
		return new PyUnicode(s);
	}

	public static PyUnicode newUnicode(String s, boolean isBasic) {
		return new PyUnicode(s, isBasic);
	}

	public static PyBoolean newBoolean(boolean t) {
		return t ? True : False;
	}

	public static PyObject newDate(java.sql.Date date) {
		if (date == null) {
			return None;
		}
		PyObject datetimeModule = __builtin__.__import__("datetime");
		PyObject dateClass = datetimeModule.__getattr__("date");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return dateClass.__call__((PyObject)Py.newInteger(cal.get(1)), (PyObject)Py.newInteger(cal.get(2) + 1), (PyObject)Py.newInteger(cal.get(5)));
	}

	public static PyObject newTime(Time time) {
		if (time == null) {
			return None;
		}
		PyObject datetimeModule = __builtin__.__import__("datetime");
		PyObject timeClass = datetimeModule.__getattr__("time");
		Calendar cal = Calendar.getInstance();
		cal.setTime(time);
		return timeClass.__call__((PyObject)Py.newInteger(cal.get(11)), (PyObject)Py.newInteger(cal.get(12)), (PyObject)Py.newInteger(cal.get(13)), (PyObject)Py.newInteger(cal.get(14) * 1000));
	}

	public static PyObject newDatetime(Timestamp timestamp) {
		if (timestamp == null) {
			return None;
		}
		PyObject datetimeModule = __builtin__.__import__("datetime");
		PyObject datetimeClass = datetimeModule.__getattr__("datetime");
		Calendar cal = Calendar.getInstance();
		cal.setTime(timestamp);
		return datetimeClass.__call__(new PyObject[]{Py.newInteger(cal.get(1)), Py.newInteger(cal.get(2) + 1), Py.newInteger(cal.get(5)), Py.newInteger(cal.get(11)), Py.newInteger(cal.get(12)), Py.newInteger(cal.get(13)), Py.newInteger(timestamp.getNanos() / 1000)});
	}

	public static PyObject newDecimal(String decimal) {
		if (decimal == null) {
			return None;
		}
		PyObject decimalModule = __builtin__.__import__("decimal");
		PyObject decimalClass = decimalModule.__getattr__("Decimal");
		return decimalClass.__call__((PyObject)Py.newString(decimal));
	}

	public static PyCode newCode(int argcount, String[] varnames, String filename, String name, boolean args, boolean keywords, PyFunctionTable funcs, int func_id, String[] cellvars, String[] freevars, int npurecell, int moreflags) {
		return new PyTableCode(argcount, varnames, filename, name, 0, args, keywords, funcs, func_id, cellvars, freevars, npurecell, moreflags);
	}

	public static PyCode newCode(int argcount, String[] varnames, String filename, String name, int firstlineno, boolean args, boolean keywords, PyFunctionTable funcs, int func_id, String[] cellvars, String[] freevars, int npurecell, int moreflags) {
		return new PyTableCode(argcount, varnames, filename, name, firstlineno, args, keywords, funcs, func_id, cellvars, freevars, npurecell, moreflags);
	}

	public static PyCode newCode(int argcount, String[] varnames, String filename, String name, boolean args, boolean keywords, PyFunctionTable funcs, int func_id) {
		return new PyTableCode(argcount, varnames, filename, name, 0, args, keywords, funcs, func_id);
	}

	public static PyCode newCode(int argcount, String[] varnames, String filename, String name, int firstlineno, boolean args, boolean keywords, PyFunctionTable funcs, int func_id) {
		return new PyTableCode(argcount, varnames, filename, name, firstlineno, args, keywords, funcs, func_id);
	}

	public static PyCode newJavaCode(Class<?> cls, String name) {
		return new JavaCode(Py.newJavaFunc(cls, name));
	}

	public static PyObject newJavaFunc(Class<?> cls, String name) {
		try {
			Method m = cls.getMethod(name, PyObject[].class, String[].class);
			return new JavaFunc(m);
		}
		catch (NoSuchMethodException e) {
			throw Py.JavaError(e);
		}
	}

	private static PyObject initExc(String name, PyObject exceptions, PyObject dict) {
		PyObject tmp = exceptions.__getattr__(name);
		dict.__setitem__(name, tmp);
		return tmp;
	}

	static void initClassExceptions(PyObject dict) {
		PyObject exc = imp.load((String)"exceptions");
		BaseException = Py.initExc("BaseException", exc, dict);
		Exception = Py.initExc("Exception", exc, dict);
		SystemExit = Py.initExc("SystemExit", exc, dict);
		StopIteration = Py.initExc("StopIteration", exc, dict);
		GeneratorExit = Py.initExc("GeneratorExit", exc, dict);
		StandardError = Py.initExc("StandardError", exc, dict);
		KeyboardInterrupt = Py.initExc("KeyboardInterrupt", exc, dict);
		ImportError = Py.initExc("ImportError", exc, dict);
		EnvironmentError = Py.initExc("EnvironmentError", exc, dict);
		IOError = Py.initExc("IOError", exc, dict);
		OSError = Py.initExc("OSError", exc, dict);
		EOFError = Py.initExc("EOFError", exc, dict);
		RuntimeError = Py.initExc("RuntimeError", exc, dict);
		NotImplementedError = Py.initExc("NotImplementedError", exc, dict);
		NameError = Py.initExc("NameError", exc, dict);
		UnboundLocalError = Py.initExc("UnboundLocalError", exc, dict);
		AttributeError = Py.initExc("AttributeError", exc, dict);
		SyntaxError = Py.initExc("SyntaxError", exc, dict);
		IndentationError = Py.initExc("IndentationError", exc, dict);
		TabError = Py.initExc("TabError", exc, dict);
		TypeError = Py.initExc("TypeError", exc, dict);
		AssertionError = Py.initExc("AssertionError", exc, dict);
		LookupError = Py.initExc("LookupError", exc, dict);
		IndexError = Py.initExc("IndexError", exc, dict);
		KeyError = Py.initExc("KeyError", exc, dict);
		ArithmeticError = Py.initExc("ArithmeticError", exc, dict);
		OverflowError = Py.initExc("OverflowError", exc, dict);
		ZeroDivisionError = Py.initExc("ZeroDivisionError", exc, dict);
		FloatingPointError = Py.initExc("FloatingPointError", exc, dict);
		ValueError = Py.initExc("ValueError", exc, dict);
		UnicodeError = Py.initExc("UnicodeError", exc, dict);
		UnicodeEncodeError = Py.initExc("UnicodeEncodeError", exc, dict);
		UnicodeDecodeError = Py.initExc("UnicodeDecodeError", exc, dict);
		UnicodeTranslateError = Py.initExc("UnicodeTranslateError", exc, dict);
		ReferenceError = Py.initExc("ReferenceError", exc, dict);
		SystemError = Py.initExc("SystemError", exc, dict);
		MemoryError = Py.initExc("MemoryError", exc, dict);
		Warning = Py.initExc("Warning", exc, dict);
		UserWarning = Py.initExc("UserWarning", exc, dict);
		DeprecationWarning = Py.initExc("DeprecationWarning", exc, dict);
		PendingDeprecationWarning = Py.initExc("PendingDeprecationWarning", exc, dict);
		SyntaxWarning = Py.initExc("SyntaxWarning", exc, dict);
		RuntimeWarning = Py.initExc("RuntimeWarning", exc, dict);
		FutureWarning = Py.initExc("FutureWarning", exc, dict);
		ImportWarning = Py.initExc("ImportWarning", exc, dict);
		UnicodeWarning = Py.initExc("UnicodeWarning", exc, dict);
		PyType.fromClass((Class)OutOfMemoryError.class);
	}

	public static synchronized boolean initPython() {
		PySystemState.initialize();
		return true;
	}

	private static Class<?> findClassInternal(String name, String reason) throws ClassNotFoundException {
		ClassLoader classLoader = Py.getSystemState().getClassLoader();
		if (classLoader != null) {
			if (reason != null) {
				Py.writeDebug("import", "trying " + name + " as " + reason + " in sys.classLoader");
			}
			return Py.loadAndInitClass(name, classLoader);
		}
		if (!syspathJavaLoaderRestricted) {
			try {
				classLoader = imp.getSyspathJavaLoader();
				if (classLoader != null && reason != null) {
					Py.writeDebug("import", "trying " + name + " as " + reason + " in SysPathJavaLoader");
				}
			}
			catch (SecurityException e) {
				syspathJavaLoaderRestricted = true;
			}
		}
		if (syspathJavaLoaderRestricted && (classLoader = imp.getParentClassLoader()) != null && reason != null) {
			Py.writeDebug("import", "trying " + name + " as " + reason + " in Jython's parent class loader");
		}
		if (classLoader != null) {
			try {
				return Py.loadAndInitClass(name, classLoader);
			}
			catch (ClassNotFoundException cnfe) {
				// empty catch block
			}
		}
		if (reason != null) {
			Py.writeDebug("import", "trying " + name + " as " + reason + " in context class loader, for backwards compatibility");
		}
		return Py.loadAndInitClass(name, Thread.currentThread().getContextClassLoader());
	}

	public static Class<?> findClass(String name) {
		try {
			return Py.findClassInternal(name, null);
		}
		catch (ClassNotFoundException e) {
			return null;
		}
		catch (IllegalArgumentException e) {
			return null;
		}
		catch (NoClassDefFoundError e) {
			return null;
		}
	}

	public static Class<?> findClassEx(String name, String reason) {
		try {
			return Py.findClassInternal(name, reason);
		}
		catch (ClassNotFoundException e) {
			return null;
		}
		catch (IllegalArgumentException e) {
			throw Py.JavaError(e);
		}
		catch (LinkageError e) {
			throw Py.JavaError(e);
		}
	}

	private static Class<?> loadAndInitClass(String name, ClassLoader loader) throws ClassNotFoundException {
		return Class.forName(name, true, loader);
	}

	public static void initProxy(PyProxy proxy, String module, String pyclass, Object[] args) {
		if (proxy._getPyInstance() != null) {
			return;
		}
		ThreadState ts = Py.getThreadState();
		PyObject instance = ts.getInitializingProxy();
		if (instance != null) {
			if (instance.javaProxy != null) {
				throw Py.TypeError("Proxy instance reused");
			}
			instance.javaProxy = proxy;
			proxy._setPyInstance(instance);
			proxy._setPySystemState(ts.systemState);
			return;
		}
		PyObject mod = imp.importName((String)module.intern(), (boolean)false);
		PyType pyc = (PyType)mod.__getattr__(pyclass.intern());
		PyObject[] pargs = args == null || args.length == 0 ? EmptyObjects : Py.javas2pys(args);
		instance = pyc.__call__(pargs);
		instance.javaProxy = proxy;
		proxy._setPyInstance(instance);
		proxy._setPySystemState(ts.systemState);
	}

	public static void runMain(PyRunnable main, String[] args) throws Exception {
		Py.runMain((CodeBootstrap)new PyRunnableBootstrap(main), args);
	}

	public static void runMain(CodeBootstrap main, String[] args) throws Exception {
		PySystemState.initialize((Properties)null, (Properties)null, (String[])args, (ClassLoader)main.getClass().getClassLoader());
		try {
			imp.createFromCode((String)"__main__", (PyCode)CodeLoader.loadCode((CodeBootstrap)main));
		}
		catch (PyException e) {
			Py.getSystemState().callExitFunc();
			if (e.match(SystemExit)) {
				return;
			}
			throw e;
		}
		Py.getSystemState().callExitFunc();
	}

	private static String getStackTrace(Throwable javaError) {
		int index0;
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		javaError.printStackTrace(new PrintStream(buf));
		String str = buf.toString();
		int index = -1;
		if (index == -1) {
			index = str.indexOf("at org.python.core.PyReflectedConstructor.__call__");
		}
		if (index == -1) {
			index = str.indexOf("at org.python.core.PyReflectedFunction.__call__");
		}
		if (index == -1) {
			index = str.indexOf("at org/python/core/PyReflectedConstructor.__call__");
		}
		if (index == -1) {
			index = str.indexOf("at org/python/core/PyReflectedFunction.__call__");
		}
		if (index != -1) {
			index = str.lastIndexOf("\n", index);
		}
		if (index >= (index0 = str.indexOf("\n"))) {
			str = str.substring(index0 + 1, index + 1);
		}
		return str;
	}

	public static void printException(Throwable t) {
		Py.printException(t, null, null);
	}

	public static void printException(Throwable t, PyFrame f) {
		Py.printException(t, f, null);
	}

	public static synchronized void printException(Throwable t, PyFrame f, PyObject file) {
		StdoutWrapper stderr = Py.stderr;
		if (file != null) {
			stderr = new FixedFileWrapper(file);
		}
		if (Options.showJavaExceptions) {
			stderr.println("Java Traceback:");
			CharArrayWriter buf = new CharArrayWriter();
			if (t instanceof PyException) {
				((PyException)t).super__printStackTrace(new PrintWriter(buf));
			} else {
				t.printStackTrace(new PrintWriter(buf));
			}
			stderr.print(buf.toString());
		}
		PyException exc = Py.JavaError(t);
		Py.maybeSystemExit(exc);
		Py.setException((Throwable)exc, f);
		ThreadState ts = Py.getThreadState();
		ts.systemState.last_value = exc.value;
		ts.systemState.last_type = exc.type;
		ts.systemState.last_traceback = exc.traceback;
		PyObject exceptHook = ts.systemState.__findattr__("excepthook");
		if (exceptHook != null) {
			try {
				exceptHook.__call__(exc.type, exc.value, (PyObject)exc.traceback);
			}
			catch (PyException exc2) {
				exc2.normalize();
				Py.flushLine();
				stderr.println("Error in sys.excepthook:");
				Py.displayException(exc2.type, exc2.value, (PyObject)exc2.traceback, file);
				stderr.println();
				stderr.println("Original exception was:");
				Py.displayException(exc.type, exc.value, (PyObject)exc.traceback, file);
			}
		} else {
			stderr.println("sys.excepthook is missing");
			Py.displayException(exc.type, exc.value, (PyObject)exc.traceback, file);
		}
		ts.exception = null;
	}

	public static void displayException(PyObject type, PyObject value, PyObject tb, PyObject file) {
		Object javaError;
		StdoutWrapper stderr = Py.stderr;
		if (file != null) {
			stderr = new FixedFileWrapper(file);
		}
		Py.flushLine();
		if (tb instanceof PyTraceback) {
			stderr.print(((PyTraceback)tb).dumpStack());
		}
		if (__builtin__.isinstance(value, SyntaxError)) {
			PyObject filename = value.__findattr__("filename");
			PyObject text = value.__findattr__("text");
			PyObject lineno = value.__findattr__("lineno");
			stderr.print("  File \"");
			stderr.print(filename == None || filename == null ? "<string>" : filename.toString());
			stderr.print("\", line ");
			stderr.print((PyObject)(lineno == null ? Py.newString("0") : lineno));
			stderr.print("\n");
			if (text != None && text != null && text.__len__() != 0) {
				Py.printSyntaxErrorText(stderr, value.__findattr__("offset").asInt(), text.toString());
			}
			if ((value = value.__findattr__("msg")) == null) {
				value = None;
			}
		}
		if (value.getJavaProxy() != null && (javaError = value.__tojava__((Class)Throwable.class)) != null && javaError != NoConversion) {
			stderr.println(Py.getStackTrace((Throwable)javaError));
		}
		stderr.println(Py.formatException(type, value));
	}

	private static void printSyntaxErrorText(StdoutWrapper out, int offset, String text) {
		if (offset >= 0) {
			int nl;
			int i;
			if (offset > 0 && offset == text.length()) {
				--offset;
			}
			while ((nl = text.indexOf("\n")) != -1) {
				if (nl >= offset) break;
				offset-=nl + 1;
				text = text.substring(nl + 1, text.length());
			}
			for (i = 0; i < text.length(); ++i) {
				char c = text.charAt(i);
				if (c != ' ' && c != '\t') break;
				--offset;
			}
			text = text.substring(i, text.length());
		}
		out.print("    ");
		out.print(text);
		if (!(text.length() != 0 && text.endsWith("\n"))) {
			out.print("\n");
		}
		if (offset == -1) {
			return;
		}
		out.print("    ");
		--offset;
		while (offset > 0) {
			out.print(" ");
			--offset;
		}
		out.print("^\n");
	}

	public static String formatException(PyObject type, PyObject value) {
		StringBuilder buf = new StringBuilder();
		if (PyException.isExceptionClass((PyObject)type)) {
			PyObject moduleName;
			String className = PyException.exceptionClassName((PyObject)type);
			int lastDot = className.lastIndexOf(46);
			if (lastDot != -1) {
				className = className.substring(lastDot + 1);
			}
			if ((moduleName = type.__findattr__("__module__")) == null) {
				if (!(type instanceof PyClass)) {
					buf.append("<unknown>");
				}
			} else {
				String moduleStr = moduleName.toString();
				if (!moduleStr.equals("exceptions")) {
					buf.append(moduleStr);
					buf.append(".");
				}
			}
			buf.append(className);
		} else {
			buf.append((Object)type.__str__());
		}
		if (value != null && value != None) {
			PyString s = value.__str__();
			if (!(s instanceof PyString && s.__len__() == 0)) {
				buf.append(": ");
			}
			buf.append((Object)s);
		}
		return buf.toString();
	}

	public static void assert_(PyObject test, PyObject message) {
		if (!test.__nonzero__()) {
			throw new PyException(AssertionError, message);
		}
	}

	public static void assert_(PyObject test) {
		Py.assert_(test, None);
	}

	public static void addTraceback(Throwable t, PyFrame frame) {
		Py.JavaError(t).tracebackHere(frame, true);
	}

	public static PyException setException(Throwable t, PyFrame frame) {
		PyException pye = Py.JavaError(t);
		pye.normalize();
		pye.tracebackHere(frame);
		Py.getThreadState().exception = pye;
		return pye;
	}

	@Deprecated
		public static boolean matchException(PyException pye, PyObject exc) {
			return pye.match(exc);
		}

	public static PyException makeException(PyObject type, PyObject value, PyObject traceback) {
		return PyException.doRaise((PyObject)type, (PyObject)value, (PyObject)traceback);
	}

	public static PyException makeException(PyObject type, PyObject value) {
		return Py.makeException(type, value, null);
	}

	public static PyException makeException(PyObject type) {
		return Py.makeException(type, null);
	}

	public static PyException makeException() {
		return Py.makeException(null);
	}

	public static PyObject runCode(PyCode code, PyObject locals, PyObject globals) {
		char f;
		ThreadState threadState = Py.getThreadState();
		if (locals == null || locals == None) {
			locals = globals != null && globals != None ? globals : threadState.frame.getLocals();
		}
		if (globals == null || globals == None) {
			globals = threadState.frame.f_globals;
		}
		PyBaseCode ts = null;
		if (code instanceof PyBaseCode) {
			ts = (PyBaseCode)code;
		}
		PyFrame baseCode = new PyFrame(ts, locals, globals, Py.getSystemState().getBuiltins());
		return code.call((ThreadState)f, baseCode);
	}

	public static PyObject runCode(PyCode code, PyObject locals, PyObject globals, CurrentLine line) {
		char f;
		ThreadState threadState = Py.getThreadState();
		if (locals == null || locals == None) {
			locals = globals != null && globals != None ? globals : threadState.frame.getLocals();
		}
		if (globals == null || globals == None) {
			globals = threadState.frame.f_globals;
		}
		PyBaseCode ts = null;
		if (code instanceof PyBaseCode) {
			ts = (PyBaseCode)code;
		}
		PyFrame baseCode = new PyFrame(ts, locals, globals, Py.getSystemState().getBuiltins());
		line.setLine(baseCode.getline());
		return code.call((ThreadState)f, baseCode);
	}

	public static void exec(PyObject o, PyObject globals, PyObject locals) {
		PyCode fp;
		Object flags;
		boolean bl = false;
		if (o instanceof PyTuple) {
			flags = (PyTuple)o;
			int tuple = flags.__len__();
			if ((globals == null || globals.equals((Object)None)) && (locals == null || locals.equals((Object)None)) && tuple >= 2 && tuple <= 3) {
				o = flags.__getitem__(0);
				globals = flags.__getitem__(1);
				if (tuple == 3) {
					locals = flags.__getitem__(2);
				}
			}
		}
		if (o instanceof PyCode) {
			PyCode len = (PyCode)o;
			if (locals == null && o instanceof PyBaseCode && ((PyBaseCode)o).hasFreevars()) {
				throw Py.TypeError("code object passed to exec may not contain free variables");
			}
		} else {
			flags = null;
			if (o instanceof PyString) {
				if (o instanceof PyUnicode) {
					// empty if block
				}
				flags = o.toString();
			} else if (o instanceof PyFile) {
				PyFile contents = (PyFile)o;
				if (contents.getClosed()) {
					return;
				}
				flags = contents.read().toString();
			} else {
				throw Py.TypeError("exec: argument 1 must be string, code or file object");
			}
			fp = Py.compile_flags((String)flags, "<string>", CompileMode.exec, Py.getCompilerFlags(code|=256, false));
		}
		Py.runCode(fp, locals, globals);
	}

	public static final ThreadState getThreadState() {
		return Py.getThreadState(null);
	}

	public static final ThreadState getThreadState(PySystemState newSystemState) {
		return threadStateMapping.getThreadState(newSystemState);
	}

	public static final PySystemState setSystemState(PySystemState newSystemState) {
		ThreadState ts = Py.getThreadState(newSystemState);
		PySystemState oldSystemState = ts.systemState;
		if (oldSystemState != newSystemState) {
			ts.systemState = newSystemState;
		}
		return oldSystemState;
	}

	public static final PySystemState getSystemState() {
		return Py.getThreadState().systemState;
	}

	public static PyFrame getFrame() {
		ThreadState ts = Py.getThreadState();
		if (ts == null) {
			return null;
		}
		return ts.frame;
	}

	public static void setFrame(PyFrame f) {
		Py.getThreadState().frame = f;
	}

	public static void print(PyObject file, PyObject o) {
		if (file == None) {
			Py.print(o);
		} else {
			new FixedFileWrapper(file).print(o);
		}
	}

	public static void printComma(PyObject file, PyObject o) {
		if (file == None) {
			Py.printComma(o);
		} else {
			new FixedFileWrapper(file).printComma(o);
		}
	}

	public static void println(PyObject file, PyObject o) {
		if (file == None) {
			Py.println(o);
		} else {
			new FixedFileWrapper(file).println(o);
		}
	}

	public static void printlnv(PyObject file) {
		if (file == None) {
			Py.println();
		} else {
			new FixedFileWrapper(file).println();
		}
	}

	public static void print(PyObject o) {
		stdout.print(o);
	}

	public static void printComma(PyObject o) {
		stdout.printComma(o);
	}

	public static void println(PyObject o) {
		stdout.println(o);
	}

	public static void println() {
		stdout.println();
	}

	public static void flushLine() {
		stdout.flushLine();
	}

	public static boolean py2boolean(PyObject o) {
		return o.__nonzero__();
	}

	public static byte py2byte(PyObject o) {
		if (o instanceof PyInteger) {
			return (byte)((PyInteger)o).getValue();
		}
		Object i = o.__tojava__(Byte.TYPE);
		if (i == null || i == NoConversion) {
			throw Py.TypeError("integer required");
		}
		return ((Byte)i).byteValue();
	}

	public static short py2short(PyObject o) {
		if (o instanceof PyInteger) {
			return (short)((PyInteger)o).getValue();
		}
		Object i = o.__tojava__(Short.TYPE);
		if (i == null || i == NoConversion) {
			throw Py.TypeError("integer required");
		}
		return (Short)i;
	}

	public static int py2int(PyObject o) {
		return Py.py2int(o, "integer required");
	}

	public static int py2int(PyObject o, String msg) {
		if (o instanceof PyInteger) {
			return ((PyInteger)o).getValue();
		}
		Object obj = o.__tojava__(Integer.TYPE);
		if (obj == NoConversion) {
			throw Py.TypeError(msg);
		}
		return (Integer)obj;
	}

	public static long py2long(PyObject o) {
		if (o instanceof PyInteger) {
			return ((PyInteger)o).getValue();
		}
		Object i = o.__tojava__(Long.TYPE);
		if (i == null || i == NoConversion) {
			throw Py.TypeError("integer required");
		}
		return (Long)i;
	}

	public static float py2float(PyObject o) {
		if (o instanceof PyFloat) {
			return (float)((PyFloat)o).getValue();
		}
		if (o instanceof PyInteger) {
			return ((PyInteger)o).getValue();
		}
		Object i = o.__tojava__(Float.TYPE);
		if (i == null || i == NoConversion) {
			throw Py.TypeError("float required");
		}
		return ((Float)i).floatValue();
	}

	public static double py2double(PyObject o) {
		if (o instanceof PyFloat) {
			return ((PyFloat)o).getValue();
		}
		if (o instanceof PyInteger) {
			return ((PyInteger)o).getValue();
		}
		Object i = o.__tojava__(Double.TYPE);
		if (i == null || i == NoConversion) {
			throw Py.TypeError("float required");
		}
		return (Double)i;
	}

	public static char py2char(PyObject o) {
		return Py.py2char(o, "char required");
	}

	public static char py2char(PyObject o, String msg) {
		if (o instanceof PyString) {
			PyString s = (PyString)o;
			if (s.__len__() != 1) {
				throw Py.TypeError(msg);
			}
			return s.toString().charAt(0);
		}
		if (o instanceof PyInteger) {
			return (char)((PyInteger)o).getValue();
		}
		Object i = o.__tojava__(Character.TYPE);
		if (i == null || i == NoConversion) {
			throw Py.TypeError(msg);
		}
		return ((Character)i).charValue();
	}

	public static void py2void(PyObject o) {
		if (o != None) {
			throw Py.TypeError("None required for void return");
		}
	}

	public static final PyString makeCharacter(Character o) {
		return Py.makeCharacter(o.charValue());
	}

	public static final PyString makeCharacter(char c) {
		return Py.makeCharacter(c, false);
	}

	static final PyString makeCharacter(int codepoint, boolean toUnicode) {
		if (toUnicode) {
			return new PyUnicode(codepoint);
		}
		if (codepoint > 65536) {
			throw new IllegalArgumentException(String.format("Codepoint > 65536 (%d) requires toUnicode argument", codepoint));
		}
		if (codepoint > 256) {
			return new PyString((char)codepoint);
		}
		return letters[codepoint];
	}

	public static PyObject java2py(Object o) {
		return Py.getAdapter().adapt(o);
	}

	public static /* varargs */ PyObject[] javas2pys(Object ... objects) {
		PyObject[] objs = new PyObject[objects.length];
		for (int i = 0; i < objs.length; ++i) {
			objs[i] = Py.java2py(objects[i]);
		}
		return objs;
	}

	public static ExtensiblePyObjectAdapter getAdapter() {
		if (adapter == null) {
			adapter = new ClassicPyObjectAdapter();
		}
		return adapter;
	}

	protected static void setAdapter(ExtensiblePyObjectAdapter adapter) {
		Py.adapter = adapter;
	}

	public static PyObject makeClass(String name, PyObject[] bases, PyCode code) {
		return Py.makeClass(name, bases, code, null);
	}

	public static PyObject makeClass(String name, PyObject[] bases, PyCode code, PyObject[] closure_cells) {
		ThreadState state = Py.getThreadState();
		PyObject dict = code.call(state, EmptyObjects, NoKeywords, state.frame.f_globals, EmptyObjects, (PyObject)new PyTuple(closure_cells));
		return Py.makeClass(name, bases, dict);
	}

	public static PyObject makeClass(String name, PyObject base, PyObject dict) {
		PyObject[] arrpyObject;
		if (base == null) {
			arrpyObject = EmptyObjects;
		} else {
			PyObject[] arrpyObject2 = new PyObject[1];
			arrpyObject = arrpyObject2;
			arrpyObject2[0] = base;
		}
		PyObject[] bases = arrpyObject;
		return Py.makeClass(name, bases, dict);
	}

	public static PyObject makeClass(String name, PyObject[] bases, PyObject dict) {
		PyObject metaclass = dict.__finditem__("__metaclass__");
		if (metaclass == null) {
			if (bases.length != 0) {
				PyObject base = bases[0];
				metaclass = base.__findattr__("__class__");
				if (metaclass == null) {
					metaclass = base.getType();
				}
			} else {
				PyObject globals = Py.getFrame().f_globals;
				if (globals != null) {
					metaclass = globals.__finditem__("__metaclass__");
				}
				if (metaclass == null) {
					metaclass = PyClass.TYPE;
				}
			}
		}
		try {
			return metaclass.__call__((PyObject)new PyString(name), (PyObject)new PyTuple(bases), dict);
		}
		catch (PyException pye) {
			if (!pye.match(TypeError)) {
				throw pye;
			}
			pye.value = Py.newString(String.format("Error when calling the metaclass bases\n    %s", pye.value.__str__().toString()));
			throw pye;
		}
	}

	public static synchronized String getName() {
		String name = "org.python.pycode._pyx" + nameindex;
		++nameindex;
		return name;
	}

	public static CompilerFlags getCompilerFlags() {
		return CompilerFlags.getCompilerFlags();
	}

	public static CompilerFlags getCompilerFlags(int flags, boolean dont_inherit) {
		PyFrame frame = dont_inherit ? null : Py.getFrame();
		return CompilerFlags.getCompilerFlags((int)flags, (PyFrame)frame);
	}

	public static CompilerFlags getCompilerFlags(CompilerFlags flags, boolean dont_inherit) {
		PyFrame frame = dont_inherit ? null : Py.getFrame();
		return CompilerFlags.getCompilerFlags((CompilerFlags)flags, (PyFrame)frame);
	}

	public static PyCode compile(InputStream istream, String filename, CompileMode kind) {
		return Py.compile_flags(istream, filename, kind, new CompilerFlags());
	}

	public static PyCode compile_flags(mod node, String name, String filename, boolean linenumbers, boolean printResults, CompilerFlags cflags) {
		return CompilerFacade.compile((mod)node, (String)name, (String)filename, (boolean)linenumbers, (boolean)printResults, (CompilerFlags)cflags);
	}

	public static PyCode compile_flags(mod node, String filename, CompileMode kind, CompilerFlags cflags) {
		return Py.compile_flags(node, Py.getName(), filename, true, kind == CompileMode.single, cflags);
	}

	public static PyCode compile_flags(InputStream istream, String filename, CompileMode kind, CompilerFlags cflags) {
		mod node = ParserFacade.parse((InputStream)istream, (CompileMode)kind, (String)filename, (CompilerFlags)cflags);
		return Py.compile_flags(node, filename, kind, cflags);
	}

	public static PyCode compile_flags(String data, String filename, CompileMode kind, CompilerFlags cflags) {
		if (data.contains((CharSequence)"\u0000")) {
			throw Py.TypeError("compile() expected string without null bytes");
		}
		data = cflags != null && cflags.dont_imply_dedent ? data + "\n" : data + "\n\n";
		mod node = ParserFacade.parse((String)data, (CompileMode)kind, (String)filename, (CompilerFlags)cflags);
		return Py.compile_flags(node, filename, kind, cflags);
	}

	public static PyObject compile_command_flags(String string, String filename, CompileMode kind, CompilerFlags cflags, boolean stdprompt) {
		mod node = ParserFacade.partialParse((String)(string + "\n"), (CompileMode)kind, (String)filename, (CompilerFlags)cflags, (boolean)stdprompt);
		if (node == null) {
			return None;
		}
		return Py.compile_flags(node, Py.getName(), filename, true, true, cflags);
	}

	public static PyObject[] unpackSequence(PyObject obj, int length) {
		if (obj instanceof PyTuple && obj.__len__() == length) {
			return ((PyTuple)obj).getArray();
		}
		PyObject[] ret = new PyObject[length];
		PyObject iter = obj.__iter__();
		for (int i = 0; i < length; ++i) {
			PyObject tmp = iter.__iternext__();
			if (tmp == null) {
				Object[] arrobject = new Object[2];
				arrobject[0] = i;
				arrobject[1] = i == 1 ? "" : "s";
				throw Py.ValueError(String.format("need more than %d value%s to unpack", arrobject));
			}
			ret[i] = tmp;
		}
		if (iter.__iternext__() != null) {
			throw Py.ValueError("too many values to unpack");
		}
		return ret;
	}

	public static PyObject iter(PyObject seq, String message) {
		try {
			return seq.__iter__();
		}
		catch (PyException exc) {
			if (exc.match(TypeError)) {
				throw Py.TypeError(message);
			}
			throw exc;
		}
	}

	public static long id(PyObject o) {
		return idimpl.id(o);
	}

	public static String idstr(PyObject o) {
		return idimpl.idstr(o);
	}

	public static long java_obj_id(Object o) {
		return idimpl.java_obj_id(o);
	}

	public static void printResult(PyObject ret) {
		Py.getThreadState().systemState.invoke("displayhook", ret);
	}

	public static void maybeWrite(String type, String msg, int level) {
		if (level <= Options.verbose) {
			System.err.println(type + ": " + msg);
		}
	}

	public static void writeError(String type, String msg) {
		Py.maybeWrite(type, msg, -1);
	}

	public static void writeWarning(String type, String msg) {
		Py.maybeWrite(type, msg, 0);
	}

	public static void writeMessage(String type, String msg) {
		Py.maybeWrite(type, msg, 1);
	}

	public static void writeComment(String type, String msg) {
		Py.maybeWrite(type, msg, 2);
	}

	public static void writeDebug(String type, String msg) {
		Py.maybeWrite(type, msg, 3);
	}

	public static void saveClassFile(String name, ByteArrayOutputStream bytestream) {
		String dirname = Options.proxyDebugDirectory;
		if (dirname == null) {
			return;
		}
		byte[] bytes = bytestream.toByteArray();
		File dir = new File(dirname);
		File file = Py.makeFilename(name, dir);
		new File(file.getParent()).mkdirs();
		try {
			FileOutputStream o = new FileOutputStream(file);
			o.write(bytes);
			o.close();
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private static File makeFilename(String name, File dir) {
		int index = name.indexOf(".");
		if (index == -1) {
			return new File(dir, name + ".class");
		}
		return Py.makeFilename(name.substring(index + 1, name.length()), new File(dir, name.substring(0, index)));
	}

	private static boolean abstract_issubclass(PyObject derived, PyObject cls) {
		if (derived == cls) {
			return true;
		}
		PyObject bases = derived.__findattr__("__bases__");
		if (bases == null) {
			return false;
		}
		for (int i = 0; i < bases.__len__(); ++i) {
			if (!Py.abstract_issubclass(bases.__getitem__(i), cls)) continue;
			return true;
		}
		return false;
	}

	public static boolean isInstance(PyObject inst, PyObject cls) {
		return Py.recursiveIsInstance(inst, cls, 0);
	}

	private static boolean recursiveIsInstance(PyObject inst, PyObject cls, int recursionDepth) {
		if (cls instanceof PyClass && inst instanceof PyInstance) {
			PyClass inClass = (PyClass)inst.fastGetClass();
			return inClass.isSubClass((PyClass)cls);
		}
		if (cls instanceof PyType) {
			PyType type = (PyType)cls;
			if (inst instanceof PyStringMap && type.equals((Object)PyDictionary.TYPE)) {
				return true;
			}
			PyType instType = inst.getType();
			if (instType == type || instType.isSubType(type)) {
				return true;
			}
			PyObject c = inst.__findattr__("__class__");
			if (c != null && c != instType && c instanceof PyType) {
				return ((PyType)c).isSubType(type);
			}
			return false;
		}
		if (cls instanceof PyTuple) {
			if (recursionDepth > Py.getSystemState().getrecursionlimit()) {
				throw Py.RuntimeError("nest level of tuple too deep");
			}
			for (PyObject tupleItem : ((PyTuple)cls).getArray()) {
				if (!Py.recursiveIsInstance(inst, tupleItem, recursionDepth + 1)) continue;
				return true;
			}
			return false;
		}
		if (cls.__findattr__("__bases__") == null) {
			throw Py.TypeError("isinstance() arg 2 must be a class, type, or tuple of classes and types");
		}
		PyObject icls = inst.__findattr__("__class__");
		if (icls == null) {
			return false;
		}
		return Py.abstract_issubclass(icls, cls);
	}

	public static boolean isSubClass(PyObject derived, PyObject cls) {
		return Py.isSubClass(derived, cls, 0);
	}

	private static boolean isSubClass(PyObject derived, PyObject cls, int recursionDepth) {
		if (derived instanceof PyType && cls instanceof PyType) {
			if (derived == cls) {
				return true;
			}
			PyType type = (PyType)cls;
			PyType subtype = (PyType)derived;
			if (type == PyDictionary.TYPE && subtype == PyType.fromClass((Class)PyStringMap.class)) {
				return true;
			}
			return subtype.isSubType(type);
		}
		if (cls instanceof PyClass && derived instanceof PyClass) {
			return ((PyClass)derived).isSubClass((PyClass)cls);
		}
		if (cls.getClass() == PyTuple.class) {
			if (recursionDepth > Py.getSystemState().getrecursionlimit()) {
				throw Py.RuntimeError("nest level of tuple too deep");
			}
			for (int i = 0; i < cls.__len__(); ++i) {
				if (!Py.isSubClass(derived, cls.__getitem__(i), recursionDepth + 1)) continue;
				return true;
			}
			return false;
		}
		if (derived.__findattr__("__bases__") == null) {
			throw Py.TypeError("issubclass() arg 1 must be a class");
		}
		if (cls.__findattr__("__bases__") == null) {
			throw Py.TypeError("issubclass() arg 2 must be a class, type, or tuple of classes and types");
		}
		return Py.abstract_issubclass(derived, cls);
	}

	static PyObject[] make_array(PyObject iterable) {
		if (iterable instanceof PySequenceList) {
			return ((PySequenceList)iterable).getArray();
		}
		int n = 10;
		if (!(iterable instanceof PyGenerator)) {
			try {
				n = iterable.__len__();
			}
			catch (PyException pye) {
				// empty catch block
			}
		}
		ArrayList<PyObject> objs = new ArrayList<PyObject>(n);
		for (PyObject item : iterable.asIterable()) {
			objs.add(item);
		}
		return objs.toArray((T[])EmptyObjects);
	}

	static {
		char j;
		TPFLAGS_HEAPTYPE = 512;
		TPFLAGS_BASETYPE = 1024;
		BOOTSTRAP_TYPES = Generic.set();
		BOOTSTRAP_TYPES.add(PyObject.class);
		BOOTSTRAP_TYPES.add(PyType.class);
		BOOTSTRAP_TYPES.add(PyBuiltinCallable.class);
		BOOTSTRAP_TYPES.add(PyDataDescr.class);
		integerCache = new PyInteger[1000];
		for (j = "\\uffffff9c"; j < "\\u0384"; ++j) {
			Py.integerCache[j + 100] = new PyInteger((int)j);
		}
		syspathJavaLoaderRestricted = false;
		threadStateMapping = new ThreadStateMapping();
		letters = new PyString[256];
		for (j = '\u0000'; j < '\u0100'; j = (char)(j + '\u0001')) {
			Py.letters[j] = new PyString(new Character(j).toString());
		}
		nameindex = 0;
		idimpl = new IdImpl();
	}
}
