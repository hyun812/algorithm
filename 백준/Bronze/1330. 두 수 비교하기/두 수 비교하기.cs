using System;

namespace Baekjoon
{
    class Program
    {
        static void Main(string[] args)
        {
            string input1 = Console.ReadLine();

            string[] input = input1.Split();

            if(int.Parse(input[0]) > int.Parse(input[1]))
            {
                Console.WriteLine(">");
            }
            else if(int.Parse(input[0]) < int.Parse(input[1]))
            {
                Console.WriteLine("<");
            }
            else if(int.Parse(input[0]) == int.Parse(input[1]))
            {
                Console.WriteLine("==");
            }
        }
    }
}
