# USE CASE 4: Produce a report of top N populated cities in the world, continent, region, country and district organized by largest population to smallest.Produce a Report on the on countries in the world, continent and region by largest population to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

Database manager wants to produce a report of top N populated cities in the world, continent, region, country and district organized by largest population to smallest.

### Scope

Organization

### Level

Primary task.

### Preconditions

Database contains world population data.

### Success End Condition

A report is available containing  top N populated cities in the world, continent, region, country and district

### Failed End Condition

No report is produced.

### Primary Actor

Database Manager

### Trigger

A request for report is sent to Database Manager.

## MAIN SUCCESS SCENARIO


1. The top N populated cities in the world where N is provided by the user.
2. The top N populated cities in a continent where N is provided by the user.
3. The top N populated cities in a region where N is provided by the user.
4. The top N populated cities in a country where N is provided by the user.
5. The top N populated cities in a district where N is provided by the user.
6. A city report requires the following columns:
   1.Name.
   2.Country.
   3.District.
   4.Population.

## EXTENSIONS



## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0