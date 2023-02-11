import random
import os.path
import json

random.seed()


def draw_board(board):
    print(" ----------- ")
    print("| {} | {} | {} |".format(board[0], board[1], board[2]))
    print(" ----------- ")
    print("| {} | {} | {} |".format(board[3], board[4], board[5]))
    print(" ----------- ")
    print("| {} | {} | {} |".format(board[6], board[7], board[8]))
    print(" ----------- ")


def welcome(board):
    print('Welcome to the "Unbeatable Noughts and Crosses" game.\n'
          'The board layout is shown below:')
    draw_board(board)
    print('When prompted, enter the number corresponding to the square you want.')


def initialise_board(board):
    for i in range(9):
        board.append(" ")
    return board


def get_player_move(board):
    print("Your move (1-9): ", end="")
    move = int(input().strip())
    row, col = (move - 1) // 3, (move - 1) % 3
    while board[row * 3 + col] != ' ':
        print("The cell is not empty. Try Again!")
        print("Your move (1-9): ", end="")
        move = int(input().strip())
        row, col = (move - 1) // 3, (move - 1) % 3
    board[row * 3 + col] = 'X'
    return row, col


def choose_computer_move(board):
    print("Computer move")
    free_cells = [i for i in range(9) if board[i] == " "]
    move = random.choice(free_cells)
    row, col = move // 3, move % 3
    board[row * 3 + col] = 'O'
    return row, col


def check_for_win(board, mark):
    win_conditions = [(0, 1, 2), (3, 4, 5), (6, 7, 8), (0, 3, 6), (1, 4, 7), (2, 5, 8), (0, 4, 8), (2, 4, 6)]
    for row, col1, col2 in win_conditions:
        if board[row] == board[col1] == board[col2] == mark:
            return True
    return False


def check_for_draw(board):
    return not " " in board


def play_game():
    board = []
    initialise_board(board)
    welcome(board)
    while True:
        _, col = get_player_move(board)
        draw_board(board)
        if check_for_win(board, 'X'):
            return 1
        elif check_for_draw(board):
            return 0
        _, col = choose_computer_move(board)
        draw_board(board)
        if check_for_win(board, 'O'):
            return -1
        elif check_for_draw(board):
            return 0


def menu():
    print("1 - Play the game")
    print("2 - Save score in file 'leaderboard.txt'")
    print("3 - Load and display the scores from the 'leaderboard.txt'")
    print("q - End the program")
    choice = input("Enter your choice (1, 2, 3 or q): ")
    return choice


def load_scores():
    leaders = {}
    if os.path.exists("leaderboard.txt"):
        with open("leaderboard.txt", "r") as file:
            leaders = json.load(file)
    return leaders


def save_score(score):
    player_name = input("Enter your name: ")
    leaders = load_scores()
    leaders[player_name] = score
    if player_name in leaders:
        leaders[player_name] += result
    else:
        leaders[player_name] = result
    with open("leaderboard.txt", "w") as file:
        json.dump(leaders, file)


def display_scores(leaders):
    print("Leaderboard:")
    for name, score in leaders.items():
        print("{}: {}".format(name, score))


