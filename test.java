

class OffLineCache{	
			static int cache[] = new int[3]; // cache array with size of 3, stores the data that may be requested
			static int MemoryArray[] ; // sequence of requests made by the user
			
			//initializes the cache with the first three elements in the array
		
			public static void initialization(){
				// if the request array is less than the cache size, it adds all the elements it needs to into the cache
				if(MemoryArray.length < 3){ 
					for(int i = 0; i < MemoryArray.length; i++){
						cache[i] = MemoryArray[i];
					}
				}
				//otherwise, the first three elements of the request array are added into the cache
				else{
					for(int i = 0; i < cache.length; i++){
						cache[i] = MemoryArray[i];
					}
		

				}
				
		

			}
		

			// checks if the request is in the cache, if it is it returns true, else returns false
			public static Boolean isHit(int x){
				for(int i = 0; i < cache.length; i++){
					if(cache[i] == x){
						return true;
					}
				}
				return false;
			}
		

			// if the request was not in the cache, this updates the cache to include it
			// removes the request in the cache that is "farthest in future"
			public static void updateCache(int x, int index){
				int one = 0;
				int two = 0;
				int three = 0;	
		

				for(int i = index; i < MemoryArray.length; i++){
					//checks where the cache element appears first again in the request array and 
					//puts the index in it's respective variable if the variable is still 0
					if(cache[0] == MemoryArray[i] && one == 0){
						one = i;
					}
					if(cache[1] == MemoryArray[i] && two == 0){
						two = i;
					}
					if(cache[2] == MemoryArray[i] && three == 0){
						three = i;
					}
					
				}
				// if any of the indexes are still 0, that cache place is the one to get replaced 
				// because it is "farthest in the future"
				if(one == 0){
					cache[0] = x;
				}
				else if(two == 0){
					cache[1] = x;
				}
				else if(three == 0){
					cache[2] = x;
				}
				//otherwise, it checks whichever index is the largest and sets the respective cache
				//place to the new variable
				else{
					if((one > two && one > three) || one == 0){
						cache[0] = x;
					}
					else if(two > one && two > three ){
						cache[1] = x;
					}
					else if(three > one && three > two ){
						cache[2] = x;
		

					}
				}
		

				
		

		

			}
		

			// completes the request and updates the hit and miss count
			public static void serviceRequest(){
				int hitCount = 0;
				int missCount = 0;
				for(int i = 3; i < MemoryArray.length; i++){
					//for every element in the request array, it prints the cache and checks the hits and
					//miss for each element to the current cache
					System.out.println("In Cache right now " + cache[0] + " " + cache[1] + " " + cache[2]);
					if(isHit(MemoryArray[i])){
						//if isHit returns true, it increments the hit counter
						hitCount++;
					}
					else{
						//if isHit returns false, it increments the miss counter, and calls to update the
						//cache array
						missCount++;
						updateCache(MemoryArray[i], i);
						
					}
		

				}
				System.out.println("Hit Count " + hitCount);
				System.out.println("Miss Count " + missCount);
			}
		

			//
			public static void main (String[]args){
						
				// service request is taken as a command line argument, if there aren't any, it asks the user to try again
				if (args.length == 0) {
					System.out.println("Too Few Args");
					System.out.println("Usage: java FarthestInFuture n1 n2 n3");
					return;
				}
			
				
				// parses the arguments and puts the request in the allocated array
				MemoryArray = new int[args.length];
				for(int i = 0; i < args.length; i++){
					MemoryArray[i] =Integer.parseInt(args[i]);
				}
				
				//calls to initialize the cache
				initialization();
				//calls to fulfil the rest of the requests
				serviceRequest();
		

		

			}
		

			
		

		}

