Please add to your application code which includes passing by reference. Please don't add returning the reference from method. Make creation of the new object in method where you pass value by reference (the new object is for value). Please analyze the code structure, change the code by returning the value of scalar type and object type. I want to have the following heap structure:

Only relative option: Heap should be divided to Old and Young generations of equal size, where areas of Young generation are in following ratio:  3-Eden, 1-S0, 1-S1
Fixed by Heap size option: Heap should be of 512MB and divided to Old and Young generations of equal size, where areas of Young generation are in following ratio:  3-Eden, 1-S0, 1-S1
Fixed by Heap and Old generation size option: Heap should be of 512MB with Old generation of 128MB and Young generation with areas in following ratio:  3-Eden, 1-S0, 1-S1
Fixed by Old and Young generation option: Heap should be divided to Old generation of 128MB and Young generations of 384MB, where areas of Young generation are in following ratio:  3-Eden, 1-S0, 1-S1
Fixed by all areas: Heap should be divided to Old generation of 128MB and Young generations with areas:  Eden of 384MB, S0 of 128MB, S1 of 128MB
BTW: give 1M to thread stack


--------------------
heap = old gen + young gen
young gen = eden + s0 + s1

1. Only relative option: Heap should be divided to Old and Young generations of equal size, where areas of Young generation are in following ratio:  3-Eden, 1-S0, 1-S1
-XX:SurvivorRatio=5 - s0=1/5,s1=1/5,eden=3/5
-XX:NewRatio=1 - same size of old and young generation
 
2. Fixed by Heap size option: Heap should be of 512MB and divided to Old and Young generations of equal size, where areas of Young generation are in following ratio:  3-Eden, 1-S0, 1-S1
-Xmx=512MB  // max heap size is 512MB
-XX:NewRatio=1 (for how many times old gen > young gen)
-XX:SurvivorRatio=5

3. 
-Xmx=512MB // max heap size
-XX:NewRatio=1/3  // yg * 1/3 = og
-XX:SurvivorRatio=5

4.
-XX:MaxNewSize=384MB //max size of young gen
-XX:NewRatio=1/3 // og is 1/3 of yg
-XX:SurvivorRatio=5

5. same as previous


1M to thread stack
-Xss=1MB (default size of 64bit vms)


