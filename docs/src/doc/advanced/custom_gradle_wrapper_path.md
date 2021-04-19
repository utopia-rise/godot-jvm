Sometimes a project setup is more advanced and requires to have the godot project as a module inside a bigger kotlin 
project.

For example consider the following project setup:  
![Example project setup](../assets/img/custom_gradle_wrapper_path_example_project_setup.png)  

The godot editor does not know anything about the project structure in parent directories. Hence it cannot find the 
gradle wrapper as it only looks inside it's own directory.

To accommodate for more complicated project setups, you can define the path to the gradle wrapper in the project 
settings.  
The following example would fit the projects structure above where the gradle wrapper is located a directory above the 
godot project.  
![Example project setup](../assets/img/change_gradle_wrapper_path.png)