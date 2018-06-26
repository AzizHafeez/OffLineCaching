using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        public int[] cache = new int[3];
        public int[] MemoryArray ;

         static void Main(string[] args)
        {
            Program obj = new Program();
            int lenght;

            Console.Write("Enter length of an array : ");
            lenght = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("array length : {0}", lenght);

            obj.MemoryArray = new int[lenght];

            Console.WriteLine("Enter number in array : ");

            for (int i = 0; i < obj.MemoryArray.Length; i++)
            {
                int a = 0;
                a = Convert.ToInt32(Console.ReadLine());
                obj.MemoryArray[i] = a ;
            }

            //array = myString.ToCharArray();

            if (obj.MemoryArray.Length <= 0)
            {
                Console.WriteLine("Enter minimum one arguments....");
                return;
            }
        

            obj.initiallize();
            obj.serviceRequest();

            Console.ReadKey();

            
        }

        void initiallize()
        {
            if (MemoryArray.Length < 3)
            {
                for (int i = 0; i < MemoryArray.Length; i++)
                {
                    cache[i] = MemoryArray[i];
                }
            }
            else
            {
                for (int i = 0; i < cache.Length; i++)
                {
                    cache[i] = MemoryArray[i];
                }
            }
        }

        bool wasInCache(int key)
        {
            for (int i = 0; i < cache.Length; i++)
            {
                if (cache[i] == key)
                {
                    return true;
                }
            }
            return false;
        }

        void updateCache(int x, int index)
        {
            int one = 0;
            int two = 0;
            int three = 0;

            for (int i = 0; i < MemoryArray.Length; i++)
            {
                if (cache[0] == MemoryArray[i] && one == 0)
                {
                    one = i;
                }
                if (cache[1] == MemoryArray[i] && one == 0)
                {
                    two = i;
                }
                if (cache[2] == MemoryArray[i] && one == 0)
                {
                    three = i;
                }
            }

            if (one == 0)
            {
                cache[0] = x;
            }
            else if (two == 0)
            {
                cache[1] = x;
            }
            else if (three == 0)
            {
                cache[2] = x;
            }
            else
            {
                if ((one > two && one > three) || one == 0)
                {
                    cache[0] = x;
                }
                else if (two > one && two > three)
                {
                    cache[1] = x;
                }
                else if (three > one && three > two)
                {
                    cache[2] = x;
                }
            }
        }

        void serviceRequest()
        {
            int hitCount = 0;
            int missCount = 0;

            for (int i = 3; i < MemoryArray.Length; i++)
            {
                Console.WriteLine("Right now values in cache: " + cache[0] + " " + cache[1] + " " + cache[2]);
                if (wasInCache(MemoryArray[i]))
                {
                    hitCount++;
                }
                else
                {
                    missCount++;
                    updateCache(MemoryArray[i], i);
                }
            }
            Console.WriteLine("Total Hit counts = " + hitCount);
            Console.WriteLine("Total miss counts = " + missCount);
        }
    }
}
