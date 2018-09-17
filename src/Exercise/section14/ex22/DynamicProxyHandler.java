package Exercise.section14.ex22;


import Exercise.section14.ex21.Interface;
import Exercise.section14.ex21.RealObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Date;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long timeIn = new Date().getTime();
		System.out.println("**** proxy: " + proxy.getClass() +
			", method: " + method + ", args: " + args +
			", invoked at " + timeIn + " on " + (new Date()));
		if(args != null)
			for(Object arg : args)
				System.out.println("  " + args);
		long timeOut = new Date().getTime();
		System.out.println("Method call-return time: " + (timeOut - timeIn) + " msecs");
		return method.invoke(proxied, args);		
	}
}

class SimpleDynamicProxy22 {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		// Insert a proxy and call again:
		Interface proxy = (Interface) Proxy.newProxyInstance(
			Interface.class.getClassLoader(),
			new Class[]{ Interface.class },
			new DynamicProxyHandler(real));
		consumer(proxy);		
	}
}