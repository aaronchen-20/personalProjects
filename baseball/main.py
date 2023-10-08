import requests
import json
from datetime import date

found = False
id = str(0)
name = input("give player name\n")
# date = input("give date: (YYYY-MM-DD)\n")
# date = str(date.today())
date = "2015-08-21"
print(date)

playerList = requests.get(
  'https://statsapi.mlb.com/api/v1/sports/1/players?season=2023').text

playerList = json.loads(playerList)['people']

for p in playerList:
  if p['fullName'].lower() == name.lower():

    print("found " + name)
    found = True
    id = str(p['id'])

if found == False:
  print("player not found")

url = "https://statsapi.mlb.com/api/v1/people/" + id + "?hydrate=stats(group=[hitting],type=[gameLog])"

data = requests.get(url).text

to_parse = json.loads(data)['people'][0]['stats'][0]['splits']

for p in to_parse:
  print(p['date'])
  if p['date'] == date:
    print(p['stat']['summary'])
    if p['stat']['totalBases'] > 0:
      print(name.upper() + " has " + str(p['stat']['hits']) + " hit(s) on the day")
    else:
      print("no")

# hits = to_parse['summary']

# p1= statsapi.lookup_player("ke'bryan")

# abc = statsapi.player_stat_data(p1[0]['id'], 'hitting', 'season')

# print(abc)
