## Synopsis
The repo contains our mobile version of the prototype in the DevFest22 Hackathon.
The proposed solution is a smart assisant that can plan energy consmption within smart homes based on solar panels

## Inspiration
As any family, we consume energy at home, and at the end of the month we get our billing report.  The amount of money to pay was always huge, and it was almost impossible to manage.
So what if I could find a low-cost solution and a smart way to plan out our energy consumption at home.
## What it does
Recommend usage plan for energy consuming devices according to the predicted amount of harvested energy, maximum electricity user budget and user history data.  
## How we built it
1. Mobile app: Where we can:
                         -Visualize recommended usage plan (number of hours for each device).
                         -Visualize history of energy consumption for each device.
                        -Amount of additional battery charging for the 5 upcoming days.
                        -Consumed electricity cost for the current month.
                        -Set connected devices preferences.
                        -Receive smart alerts when the cost of energy consumption exceeds the device's 
                         planned uptime or user defined budget.

2. Embedded system: built in Nvidia Jetson to deploy our RL model which predicts consumption and recommend plans, it's connected to our devices to control them (Shut down when suggested usage hours are exceeded or turn-on on user demand through mobile app)

## Challenges we ran into
- How to integrate Google Assistant features with our app. 
- How to connect devices at home.
- Data collection to train our models.

## Accomplishments that we're proud of
- Our application has an intuitive and ergonomic user interface to present the system's features.
- The model is capable of finding the optimal way to distribute the solar panels' battery over home appliances connected to our system.
- The solution meets an important requirement for a big demographic of people, all while being profitable and environment friendly.


## What we learned
- Manage solar panel related data.
- Connect smart devices and supervise their energy consumption.
- Train a large scale prediction and recommendation models for energy consumption planning.
- Use built-in intents in mobile apps to integrate vocal commands coming from Google Assistant.

## What's next for Tornado
- Extend it to manage different energies (wind, water...etc.).
- Design extra features for premium subscription plans (for example : unlimited number of devices tracked)
