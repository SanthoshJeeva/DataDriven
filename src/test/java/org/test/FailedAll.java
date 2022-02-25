package org.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class FailedAll implements IAnnotationTransformer {

	public void transform(ITestAnnotation a, Class arg1, Constructor arg2, Method arg3) {
		IRetryAnalyzer b = a.getRetryAnalyzer();
		if (b==null) {
			a.setRetryAnalyzer(Failed.class);
			
		}
		
	}

}
