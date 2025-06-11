import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //introduction of the game
        System.out.println("Welcome to the ultimate Adventure Game");
        System.out.println("Your goal is to find the hidden treasure. Choose wisely!");

        System.out.println("You are at a crossroad. Do you want to go right or left ?");
        System.out.println("type 'right' or 'left': ");
        String choice1 = scanner.nextLine().toLowerCase();

        switch(choice1){
            case "left":
                System.out.println("You walk down a dark path and find a mysterious cave.");
                System.out.println("Do you want to enter the cave or walk past it ?");
                System.out.println("type 'enter' or 'walk': ");
                String choice2 = scanner.nextLine().toLowerCase();
                switch(choice2){
                    case "enter":
                        System.out.println("Inside the cave you find a sleeping dragon.");
                        System.out.println("Do you want to fight the dragon or sneak past it?");
                        System.out.println("type 'fight' or 'sneak': ");
                        String choice3 = scanner.nextLine().toLowerCase();
                        switch(choice3){
                            case "fight":
                                System.out.println("You fight the dragon and... You are victorious!");
                                System.out.println("The dragon guards the treasure. You Win!");
                                break;
                            case "sneak":
                                System.out.println("You sneak past the dragon and find the treasure behind it. You Win!");
                                break;
                            default:
                                System.out.println("Invalid choice. You woke the dragon! You died!");
                                break;
                        }
                        break;
                    case "walk":
                        System.out.println("You walked past the cave and fell into a hidden trap. Game over.");
                        break;
                    default:
                        System.out.println("Invalid choice. You got lost in the forest. Game over.");
                        break;
                }
                break;
            case "right":
                System.out.println("Invalid choice. You got lost in the forest. Game over.");
                break;
            default:
                System.out.println("Invalid choice. You got lost in the wood, game over.");
                break;
        }


        scanner.close();
    }
}