# USE CASE 2: Produce a report of top N populated countries in the world, continent and region

## CHARACTERISTIC INFORMATION

### Goal in Context

Database manager wants to produce a report of top N populated countries in the world, continent and region

### Scope

Organization

### Level

Primary task.

### Preconditions

Database contains world population data.

### Success End Condition

A report is available containing top N populated countries in the world, continent and region

### Failed End Condition

No report is produced.

### Primary Actor

Database Manager

### Trigger

A request for report is sent to Database Manager.

## MAIN SUCCESS SCENARIO


1. The top N populated countries in the world where N is provided by the user.
2. The top N populated countries in a continent where N is provided by the user.
3. The top N populated countries in a region where N is provided by the user.
4. A country report requires the following columns:
      1.Code.
      2.Name.
      3.Continent.
      4.Region.
      5.Population.
      6.Capital.

## EXTENSIONS



## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0