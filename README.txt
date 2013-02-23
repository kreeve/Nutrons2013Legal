NUTRONs 2013 FRC Robot Code
-----

On/Off Subsystems: 
	Many of our subsystems only exhibit two states: on and off. 
As such, it is much easier for us to write a subsystem which extends 
the existing Subsystem class,and provide methods to override for 
on/off subsystems which extends it. This drastically reduces the 
amount of code we have to write and encourages uniformity within the 
code.

Lawyer:
	The purpose of lawyer is to check the validity of executing
a command. However, we are currently not using it due all commands 
being in sequences.