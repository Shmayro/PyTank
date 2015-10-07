
Decompilers online
File Name: PythonInterpreter.class, Done.

Java decompilers
APK decompiler
Download Jad
Decompilation Results

File Name: PythonInterpreter.class

Decompiler: CFR

Job status: Done.



Save  
Twitter   Facebook   Google+  Stumbleupon  LinkedIn

PythonInterpreter.class
/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  org.python.antlr.base.mod
 *  org.python.core.CompileMode
 *  org.python.core.CompilerFlags
 *  org.python.core.ParserFacade
 *  org.python.core.Py
 *  org.python.core.PyCode
 *  org.python.core.PyException
 *  org.python.core.PyFile
 *  org.python.core.PyFileReader
 *  org.python.core.PyFileWriter
 *  org.python.core.PyModule
 *  org.python.core.PyObject
 *  org.python.core.PyString
 *  org.python.core.PySystemState
 *  org.python.core.__builtin__
 */
package org.python.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.util.Properties;
import org.python.antlr.base.mod;
import org.python.core.CompileMode;
import org.python.core.CompilerFlags;
import org.python.core.ParserFacade;
import org.python.core.Py;
import org.python.core.PyCode;
import org.python.core.PyException;
import org.python.core.PyFile;
import org.python.core.PyFileReader;
import org.python.core.PyFileWriter;
import org.python.core.PyModule;
import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.core.PySystemState;
import org.python.core.__builtin__;
import org.python.util.CurrentLine;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public class PythonInterpreter {
	protected PySystemState systemState;
	PyObject globals;
	protected ThreadLocal<PyObject> threadLocals;
	protected CompilerFlags cflags = new CompilerFlags();

	public static void initialize(Properties preProperties, Properties postProperties, String[] argv) {
		PySystemState.initialize((Properties)preProperties, (Properties)postProperties, (String[])argv);
	}

	public PythonInterpreter() {
		this(null, null);
	}

	public static PythonInterpreter threadLocalStateInterpreter(PyObject dict) {
		return new PythonInterpreter(dict, null, true);
	}

	public PythonInterpreter(PyObject dict) {
		this(dict, null);
	}

	public PythonInterpreter(PyObject dict, PySystemState systemState) {
		this(dict, systemState, false);
	}

	protected PythonInterpreter(PyObject dict, PySystemState systemState, boolean useThreadLocalState) {
		if (dict == null) {
			dict = Py.newStringMap();
		}
		this.globals = dict;
		if (systemState == null) {
			systemState = Py.getSystemState();
		}
		this.systemState = systemState;
		this.setSystemState();
		if (useThreadLocalState) {
			this.threadLocals = new ThreadLocal();
		} else {
			PyModule module = new PyModule("__main__", dict);
			systemState.modules.__setitem__("__main__", (PyObject)module);
		}
	}

	public PySystemState getSystemState() {
		return this.systemState;
	}

	protected void setSystemState() {
		Py.setSystemState((PySystemState)this.getSystemState());
	}

	public void setIn(PyObject inStream) {
		this.getSystemState().stdin = inStream;
	}

	public void setIn(Reader inStream) {
		this.setIn((PyObject)new PyFileReader(inStream));
	}

	public void setIn(InputStream inStream) {
		this.setIn((PyObject)new PyFile(inStream));
	}

	public void setOut(PyObject outStream) {
		this.getSystemState().stdout = outStream;
	}

	public void setOut(Writer outStream) {
		this.setOut((PyObject)new PyFileWriter(outStream));
	}

	public void setOut(OutputStream outStream) {
		this.setOut((PyObject)new PyFile(outStream));
	}

	public void setErr(PyObject outStream) {
		this.getSystemState().stderr = outStream;
	}

	public void setErr(Writer outStream) {
		this.setErr((PyObject)new PyFileWriter(outStream));
	}

	public void setErr(OutputStream outStream) {
		this.setErr((PyObject)new PyFile(outStream));
	}

	public PyObject eval(String s) {
		this.setSystemState();
		return __builtin__.eval((PyObject)new PyString(s), (PyObject)this.getLocals());
	}

	public PyObject eval(PyObject code) {
		this.setSystemState();
		return __builtin__.eval((PyObject)code, (PyObject)this.getLocals());
	}

	public void exec(String s) {
		this.setSystemState();
		Py.exec((PyObject)Py.compile_flags((String)s, (String)"<string>", (CompileMode)CompileMode.exec, (CompilerFlags)this.cflags), (PyObject)this.getLocals(), (PyObject)null);
		Py.flushLine();
	}

	public void exec(PyObject code) {
		this.setSystemState();
		Py.exec((PyObject)code, (PyObject)this.getLocals(), (PyObject)null);
		Py.flushLine();
	}

	public void execfile(String filename) {
		PyObject locals = this.getLocals();
		this.setSystemState();
		__builtin__.execfile_flags((String)filename, (PyObject)locals, (PyObject)locals, (CompilerFlags)this.cflags);
		Py.flushLine();
	}

	public void execfile(String filename, CurrentLine line) {
		PyObject locals = this.getLocals();
		this.setSystemState();
		__builtin__.execfile_flags((String)filename, (PyObject)locals, (PyObject)locals, (CompilerFlags)this.cflags, (CurrentLine) line);
		Py.flushLine();
	}

	public void execfile(InputStream s) {
		this.execfile(s, "<iostream>");
	}

	public void execfile(InputStream s, String name) {
		this.setSystemState();
		Py.runCode((PyCode)Py.compile_flags((InputStream)s, (String)name, (CompileMode)CompileMode.exec, (CompilerFlags)this.cflags), (PyObject)null, (PyObject)this.getLocals());
		Py.flushLine();
	}

	public PyCode compile(String script) {
		return this.compile(script, "<script>");
	}

	public PyCode compile(Reader reader) {
		return this.compile(reader, "<script>");
	}

	public PyCode compile(String script, String filename) {
		return this.compile(new StringReader(script), filename);
	}

	public PyCode compile(Reader reader, String filename) {
		mod node = ParserFacade.parseExpressionOrModule((Reader)reader, (String)filename, (CompilerFlags)this.cflags);
		this.setSystemState();
		return Py.compile_flags((mod)node, (String)filename, (CompileMode)CompileMode.eval, (CompilerFlags)this.cflags);
	}

	public PyObject getLocals() {
		if (this.threadLocals == null) {
			return this.globals;
		}
		PyObject locals = this.threadLocals.get();
		if (locals != null) {
			return locals;
		}
		return this.globals;
	}

	public void setLocals(PyObject d) {
		if (this.threadLocals == null) {
			this.globals = d;
		} else {
			this.threadLocals.set(d);
		}
	}

	public void set(String name, Object value) {
		this.getLocals().__setitem__(name.intern(), Py.java2py((Object)value));
	}

	public void set(String name, PyObject value) {
		this.getLocals().__setitem__(name.intern(), value);
	}

	public PyObject get(String name) {
		return this.getLocals().__finditem__(name.intern());
	}

	public <T> T get(String name, Class<T> javaclass) {
		PyObject val = this.getLocals().__finditem__(name.intern());
		if (val == null) {
			return null;
		}
		return (T)Py.tojava((PyObject)val, javaclass);
	}

	public void cleanup() {
		this.setSystemState();
		PySystemState sys = Py.getSystemState();
		sys.callExitFunc();
		try {
			sys.stdout.invoke("flush");
		}
		catch (PyException pye) {
			// empty catch block
		}
		try {
			sys.stderr.invoke("flush");
		}
		catch (PyException pye) {
			// empty catch block
		}
		sys.cleanup();
	}
}
