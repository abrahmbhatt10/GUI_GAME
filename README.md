MUSIC GENERATOR GAME - GUI_GAME Agastya Brahmbhatt

HOW TO RUN
Note.java has the main function to run the program

Program gives a console menu with the following options:
Enter 1 to generate music
Enter 2 to change existing sheet music
Enter 3 to open/close the game window
Enter 0 to stop playing

When user selects Choice 1
The Computer generates new music melody that is displayed on the right side

When user selects Choice 2
User can change different notes at different positions giving
Melody position (0-3) and row (0-6)/col (0-15) positions in the melody

When user selects Choice 3 - the game window can be opened or closed

GAME RULES:
Rule 1: The four melodies on the right are existing sheet music.
Rule 2: You can revise or change any notes you like by giving its position.
Rule 3: You can command the game to generate new music using existing sheet music.

This music generator generates different music melodies from existing sheet music. The user can edit and revise 4 different riffs they’ve liked and heard before on a rhythm board like splice beatmaker, except instead of the board having actual notes, the board’s y-axis is marked with number 1-7, to indicate the chord tone instead of the actual note, and the board’s x-axis is time, divided 16 times, to indicate the complexity of rhythm up to the 1/16th note.
After the user inputs one riff, the computer will then take one rhythmic phrase of one particular note from each of the different riffs.
Then, the computer asks the user to input another riff. Here, the computer repeats step 2 except it takes the rhythmic phrase of one particular note which is a different chord tone than the first rhythmic phrase (if the first rhythmic phrase was of the 1rst note of the chord, then the next rhythmic phrase should be the 3 or the 5). Then, the computer overlaps it onto the rhythm from step 2, and attaches it to a different chord tone on the rhythm board. In this case, if there is any instance where two phrases overlap, the computer must shift the phrase from step 3 over by a quarter note until it doesn’t overlap with the other phrase(s). If for some reason it still overlaps, even if you’ve shifted it by 4 quarter notes, leading you to where you started, then you must find a way to delete 1 beat of either of the phrases at the most or simply find a different rhythmic pattern to play such a note on, and try to repeat what I said earlier for this step. If while shifting the phrase, a note goes off of the rhythm board, then move that note to the beginning of the rhythm board by as many beats as you are shifting.
The computer will keep finding new phrases to overlap until it has a phrase for every chord tone used in step 2. For example, if the user inputs the guitar riff for Snow, by RHCP, then the computer would find 3 new phrases (and keep 1 phrase for 1 chord tone from Snow intact when writing the new riff), because Snow uses 4 different chord tones with 4 different phrases.
At this point, the computer should have stored 7 different phrases, and can then be used to attach to particular chord tones for one measure. The phrase with the most number of beats should be assigned to the root note, and if there is a tie in the number of beats, then the computer can randomly select which particular phrase they want assigned. Either way, the phrases with the max number of beats should be assigned to the chord tones 1,3,5, and all the other notes should be assigned to chordtones such as the 2,4, or maybe even 6. 
The computer takes the chord progression of one of the riffs (the computer can figure this out by finding out which bass-note repeats twice, and then the computer can tell whether the chords are repeating every 2 or every 4 measures), and then decides to attach that chord progression to the riff.
At this point, the computer asks the user whether he wants his riff to repeat every 2 measures or simply ever one measure. If the user says one measure, then play the assigned phrases to chord tones for the chord tones of one chord, and then another. If it’s ever two measures, then store the first measure riff, but then repeat steps 1-5 in order to get another 1 measure riff, and combine both of them together to get a 2 measure riff, composed of 2 different 1 measure riffs. 
The computer should have generated a new riff, and hopefully should play it to the user’s delight.
