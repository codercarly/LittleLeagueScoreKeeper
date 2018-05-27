package com.example.carly.littleleaguescorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreVisitor = 0;
    int scoreHome = 0;

    int hitsVisitor = 0;
    int hitsHome = 0;

    int pitchVisitor = 0;
    int pitchHome = 0;

    int ballCount = 0;
    int strikeCount = 0;
    int outCount = 0;

    int inning = 1;
    int inningOutCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        /**
         * Increase the score for Visitor or Home by 1.
         */
        public void addRunForVisitor(View v) {
            scoreVisitor = scoreVisitor + 1;
            displayScoreForVisitor(scoreVisitor);
        }

        public void addRunForHome(View v) {
            scoreHome = scoreHome + 1;
            displayScoreForHome(scoreHome);
        }

        /**
         * Increase the hit count for Visitor or Home by 1.
         */
        public void addHitForVisitor(View v) {
            hitsVisitor = hitsVisitor + 1;
            displayHitsForVisitor(hitsVisitor);
        }

        public void addHitForHome(View v) {
            hitsHome = hitsHome + 1;
            displayHitsForHome(hitsHome);
        }

        /**
         * Increase the pitch count for Visitor or Home by 1.
         */
        public void addPitchForVisitor(View v) {
            pitchVisitor += 1;
            displayPitchForVisitor(pitchVisitor);
        }

        public void addPitchForHome(View v) {
            pitchHome += 1;
            displayPitchForHome(pitchHome);
        }

        /**
         * Increase the ball count by 1.
         */
        public void addBall(View v) {
            ballCount = ballCount + 1;
            displayBallCount(ballCount);

            // If ball count reaches 4, reset to strike & ball count to 0.
            if (ballCount == 4) {
                ballCount = 0;
                strikeCount = 0;
                displayBallCount(ballCount);
                displayStrikeCount(strikeCount);
            }
        }

        /**
         * Increase the strike count by 1.
         */
        public void addStrike(View v) {
            strikeCount = strikeCount + 1;
            displayStrikeCount(strikeCount);

            // If strike count reaches 3, add 1 to out count and reset strike & ball count to 0.
            if (strikeCount == 3) {
                outCount += 1;
                inningOutCount += 1;
                strikeCount = 0;
                ballCount = 0;
                displayBallCount(ballCount);
                displayStrikeCount(strikeCount);
                displayOutCount(outCount);
            }
            // If the out counts reach 3, reset to 0.
            if (outCount == 3) {
                outCount = 0;
                displayOutCount(outCount);
            }
            // Check the inning out count. If it reaches 6, reset to 0 and change inning.
            if (inningOutCount == 6) {
                inning += 1;
                inningOutCount = 0;
                displayInning(inning);
            }

        }

        /**
         * Increase the out count by 1.
         */
        public void addOut(View v) {
            outCount += 1;
            inningOutCount += 1;
            displayOutCount(outCount);

            // If out count reaches 3, reset strike, ball, & out count to 0.
            if (outCount == 3) {
                strikeCount = 0;
                ballCount = 0;
                outCount = 0;
                displayBallCount(ballCount);
                displayStrikeCount(strikeCount);
                displayOutCount(outCount);
            }
            // Check the inning out count. If it reaches 6, reset to 0 and change inning.
            if (inningOutCount == 6) {
                inning += 1;
                inningOutCount = 0;
                displayInning(inning);
            }
        }

        /**
         * Displays the score for Visitor & Home.
         */
        public void displayScoreForVisitor(int score) {
            TextView scoreView = (TextView) findViewById(R.id.visitor_score);
            scoreView.setText(String.valueOf(score));
        }

        public void displayScoreForHome(int score) {
            TextView scoreView = (TextView) findViewById(R.id.home_score);
            scoreView.setText(String.valueOf(score));
        }

            /**
         * Displays the hits for Visitor & Home.
         */
        public void displayHitsForVisitor(int score) {
            TextView scoreView = (TextView) findViewById(R.id.visitor_hits);
            scoreView.setText(String.valueOf(score));
        }

        public void displayHitsForHome(int score) {
            TextView scoreView = (TextView) findViewById(R.id.home_hits);
            scoreView.setText(String.valueOf(score));
        }

        /**
         * Displays the pitch count for Visitor & Home.
         */
        public void displayPitchForVisitor(int score) {
            TextView scoreView = (TextView) findViewById(R.id.visitor_pitches);
            scoreView.setText(String.valueOf(score));
        }

        public void displayPitchForHome(int score) {
            TextView scoreView = (TextView) findViewById(R.id.home_pitches);
            scoreView.setText(String.valueOf(score));
        }

        /**
         *  Display the ball count.
         */
        public void displayBallCount(int count) {
            TextView countView = (TextView) findViewById(R.id.ballCount);
            countView.setText(String.valueOf(count));
        }

        /**
         *  Display the strike count.
         */
        public void displayStrikeCount(int count) {
            TextView countView = (TextView) findViewById(R.id.strikeCount);
            countView.setText(String.valueOf(count));
        }

        /**
         *  Display the out count.
         */
        public void displayOutCount(int count) {
            TextView countView = (TextView) findViewById(R.id.outCount);
            countView.setText(String.valueOf(count));
        }

        /**
         *  Display the inning count.
         */
        public void displayInning(int count) {
            TextView countView = (TextView) findViewById(R.id.inningCount);
            countView.setText(String.valueOf(count));
        }

        /**
         * Reset the score/stats for Visitor.
         */
        public void resetScoreVisitor(View v) {
            scoreVisitor = 0;
            hitsVisitor = 0;
            pitchVisitor = 0;
            displayScoreForVisitor(scoreVisitor);
            displayHitsForVisitor(hitsVisitor);
            displayPitchForVisitor(pitchVisitor);
        }

        /**
         * Reset the score/stats for Home.
         */
        public void resetScoreHome(View v) {
            scoreHome = 0;
            hitsHome = 0;
            pitchHome = 0;
            displayScoreForHome(scoreHome);
            displayHitsForHome(hitsHome);
            displayPitchForHome(pitchHome);
        }

        /**
         * Reset the count.
         */
        public void resetCount(View v) {
            ballCount = 0;
            strikeCount = 0;
            outCount = 0;
            displayBallCount(ballCount);
            displayStrikeCount(strikeCount);
            displayOutCount(outCount);
        }

        /**
         * Reset the inning.
         */
        public void resetInning(View v) {
            inning = 1;
            displayInning(inning);
        }
    }
