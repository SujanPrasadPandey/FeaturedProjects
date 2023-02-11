from noughtsandcrosses import *


def main():
    leaders = load_scores()
    while True:
        choice = menu()
        if choice == 'q':
            break
        if choice == '1':
            result = play_game()
            if result == 1:
                print("You won!")
            elif result == 0:
                print("Draw.")
            elif result == -1:
                print("You lost.")
        elif choice == '2':
            save_score(score)
        elif choice == '3':
            display_scores(leaders)


if __name__ == '__main__':
    main()
