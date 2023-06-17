# Requirements

*Gym Admin*

1. Create new gym (name, gym-timings, workout variations).
2. create new workouts.
    * Each gym can have n possible workout variations like weights, yoga, cardio etc. which can be laterd exted to more workouts.  
3. Add workouts to gym.
    * While defining we need to give workout timings along with available seats / slots.
    * For current scope, lets assume that only one single workout can be performed at a time.

_Customer_

1. View workout slots availability for the day.
    - filter by workout type.
    - sorted by start time (ASC).

2. View workout slots availability for the day.
    - filter by workout type and center name.
    - sorted by no of slots / seats (ASC).
    
3. Book a seat for a workout.
4. Cancel booking
5. **Bonus** : if customer is interested in a slot and no seats are available, Notify user when slots is available (email, sms).


_Other Functional Requirements_

1. Take care of the concurrency scenarios.
2. For simplicity lets assume all the operations are for single day but should be kept extensible to across days.
3. You can assume time to be integer

