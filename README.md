# Mocking a Static Method
For mocking static methods, PowerMock provides two approaches:

Use `PowerMockito.mockStatic()` to mock a static class or all the static methods in a class.

Use `PowerMockito.spy()` to mock a specific static method.

# Mocking a Final Method

The mocking of final methods is similar to static methods, except we need to use _PowerMockito.mock(class)_ in place of _mockStatic()_ method.

# Mock a Private Method

For mocking the private methods, we will use the **partial mocking using the spy()**
method. Also, we are using **WhiteBox** API to execute a private method in the class.
