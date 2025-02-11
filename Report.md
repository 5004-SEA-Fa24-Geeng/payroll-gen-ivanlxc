# Report for Payroll Generator

This report helps you demonstrate your understanding of the concepts. You should write this report after you have completed the project. 

## Technical Questions

1. What does CSV stand for? 
   CSV stands for **Comma-Separated Values**

2. Why would you declare `List<IEmployee>` instead of `ArrayList<HourlyEmployee>`?
   Using `List<IEmployee>`, we can store both `HourlyEmployee` and `SalaryEmployee` in the same list because they both implement `IEmployee`.
   If we declare `ArrayList<HourlyEmployee>`, we can only store `HourlyEmployee` objects, making the code less adaptable to future extensions.

3. When you have one class referencing another object, such as storing that object as one of the attributes of the first class - what type of relationship is that called (between has-a and is-a)?
   When a class contains another object as an attribute, it is called a **"has-a" relationship**.

4. Can you provide an example of a has-a relationship in your code (if one exists)?
   My `Employee` class (and its subclasses like `HourlyEmployee`), the method `runPayroll()` creates and returns a `PayStub` object, meaning an `Employee` "has" a `PayStub`.

5. Can you provide an example of an is-a relationship in your code (if one exists)?
   `public class HourlyEmployee extends Employee { ... }` `HourlyEmployee` inherit from `Employee`, so it is a is-a relationship.

6. What is the difference between an interface and an abstract class?
    Interface defines method signatures without implementation. It is like a contract that tells a class what must be done(methods) but it will not tell you how to do it.
    Abstract class can contain both abstract and concrete methods, but cannot be instantiated by itself.

7. What is the advantage of using an interface over an abstract class?
   The main advantage of using an interface over an abstract class is its flexibility. A class can implement multiple interfaces while it can only inherit one abstract class.

8. Is the following code valid or not? `List<int> numbers = new ArrayList<int>();`, explain why or why not. If not, explain how you can fix it.
   This code is **invalid** because Java does not allow primitive types (int) in generics. Generics only work with reference types, so we can use a wrapper class like `Integer` for `int`.

9. Which class/method is described as the "driver" for your application?
   The "driver" for this application is `public static void main(String[] args)` in the PayrollGenerator class.


10. How do you create a temporary folder for JUnit Testing? 
    We can use `@TempDir` to create a temporary directory for testing.

## Deeper Thinking 

Salary Inequality is a major issue in the United States. Even in STEM fields, women are often paid less for [entry level positions](https://www.gsb.stanford.edu/insights/whats-behind-pay-gap-stem-jobs). However, not paying equal salary can hurt representation in the field, and looking from a business perspective, can hurt the company's bottom line has diversity improves innovation and innovation drives profits. 

Having heard these facts, your employer would like data about their salaries to ensure that they are paying their employees fairly. While this is often done 'after pay' by employee surveys and feedback, they have the idea that maybe the payroll system can help them ensure that they are paying their employees fairly. They have given you free reign to explore this idea.

Think through the issue / making sure to cite any resources you use to help you better understand the topic. Then write a paragraph on what changes you would need to make to the system. For example, would there be any additional data points you would need to store in the employee file? Why? Consider what point in the payroll process you may want to look at the data, as different people could have different pretax benefits and highlight that. 

The answer to this is mostly open. We ask that you cite at least two sources to show your understanding of the issue. The TAs will also give feedback on your answer, though will be liberal in grading as long as you show a good faith effort to understand the issue and making an effort to think about how your design to could help meet your employer's goals of salary equity. 
