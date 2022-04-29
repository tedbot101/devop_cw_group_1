# USE CASE 6: Produce  a report of top N populated capital city in the world, continent and region


## CHARACTERISTIC INFORMATION

### Goal in Context

Organization wants to produce a report of top N populated capital city in the world, continent and region
### Scope

Organization

### Level

Primary task.

### Preconditions

Database service contains world population data is up

### Success End Condition

A report is available containing top N populated capital city in the world, continent and region

### Failed End Condition

No report is produced.

### Primary Actor

Organization

### Trigger

A request for report is sent to Organization.

## MAIN SUCCESS SCENARIO
The following reports with given format have been generated and made available to organization
1. The top N populated capital cities in the world where N is provided by the user.
2. The top N populated capital cities in a continent where N is provided by the user.
3. The top N populated capital cities in a region where N is provided by the user.
4. A capital city report requires the following columns:
   1.Name.
   2.Country.
   3.Population.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0