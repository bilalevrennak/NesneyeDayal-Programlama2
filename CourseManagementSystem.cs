
using System;
using System.Collections.Generic;

// Base Class
public abstract class Person
{
    public string Name { get; set; }
    public string ID { get; set; }
    
    public abstract void DisplayInfo();
}

// Derived Class: Student
public class Student : Person
{
    public List<Course> EnrolledCourses { get; set; } = new List<Course>();

    public override void DisplayInfo()
    {
        Console.WriteLine($"Student Name: {Name}, ID: {ID}");
    }
}

// Derived Class: Instructor
public class Instructor : Person
{
    public List<Course> TeachingCourses { get; set; } = new List<Course>();

    public override void DisplayInfo()
    {
        Console.WriteLine($"Instructor Name: {Name}, ID: {ID}");
    }
}

// Interface
public interface ILogin
{
    void Login();
}

// Course Class
public class Course
{
    public string CourseName { get; set; }
    public int Credits { get; set; }
    public Instructor CourseInstructor { get; set; }
    public List<Student> EnrolledStudents { get; set; } = new List<Student>();

    public void DisplayCourseInfo()
    {
        Console.WriteLine($"Course: {CourseName}, Credits: {Credits}, Instructor: {CourseInstructor.Name}");
        Console.WriteLine("Enrolled Students:");
        foreach (var student in EnrolledStudents)
        {
            Console.WriteLine($"- {student.Name}");
        }
    }
}

// Program
public class Program
{
    public static void Main(string[] args)
    {
        // Create Instructor
        Instructor instructor = new Instructor { Name = "John Doe", ID = "I123" };

        // Create Course
        Course course = new Course
        {
            CourseName = "Introduction to Programming",
            Credits = 3,
            CourseInstructor = instructor
        };

        // Assign Course to Instructor
        instructor.TeachingCourses.Add(course);

        // Create Students
        Student student1 = new Student { Name = "Alice", ID = "S001" };
        Student student2 = new Student { Name = "Bob", ID = "S002" };

        // Enroll Students in Course
        course.EnrolledStudents.Add(student1);
        course.EnrolledStudents.Add(student2);

        student1.EnrolledCourses.Add(course);
        student2.EnrolledCourses.Add(course);

        // Display Information
        instructor.DisplayInfo();
        course.DisplayCourseInfo();
    }
}
