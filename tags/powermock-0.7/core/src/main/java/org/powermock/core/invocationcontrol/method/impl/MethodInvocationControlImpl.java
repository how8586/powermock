/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.powermock.core.invocationcontrol.method.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.powermock.core.invocationcontrol.method.MethodInvocationControl;


/**
 * The default implementation of the {@link MethodInvocationControl} interface.
 * 
 * @author Johan Haleby
 */
public class MethodInvocationControlImpl implements MethodInvocationControl {

	private InvocationHandler invocationHandler;

	private Set<Method> mockedMethods;

	/**
	 * Initializes internal state.
	 * 
	 * @param invocationHandler
	 *            The mock invocation handler to be associated with this instance.
	 * @param methodsToMock
	 *            The methods that are mocked for this instance. If
	 *            <code>methodsToMock</code> is null or empty, all methods for
	 *            the <code>invocationHandler</code> are considered to be
	 *            mocked.
	 */
	public MethodInvocationControlImpl(InvocationHandler invocationHandler,
			Set<Method> methodsToMock) {
		if (invocationHandler == null) {
			throw new IllegalArgumentException(
					"Invocation Handler cannot be null.");
		}

		if (methodsToMock == null) {
			methodsToMock = new HashSet<Method>();
		}

		this.invocationHandler = invocationHandler;
		this.mockedMethods = methodsToMock;
	}

	/**
	 * {@inheritDoc}
	 */
	public InvocationHandler getInvocationHandler() {
		return invocationHandler;
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<Method> getMockedMethods() {
		return mockedMethods;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isMocked(Method method) {
		return mockedMethods.isEmpty() || mockedMethods.contains(method);
	}
}
