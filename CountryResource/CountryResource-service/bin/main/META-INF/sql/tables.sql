create table FOO_Continent (
	continentCode VARCHAR(75) not null primary key,
	continentName VARCHAR(75) null
);

create table FOO_Country (
	countryCode VARCHAR(75) not null primary key,
	continentCode VARCHAR(75) null,
	countryName VARCHAR(75) null,
	fullName VARCHAR(75) null
);

create table FOO_States (
	stateAbbrev VARCHAR(75) not null primary key,
	stateName VARCHAR(75) null,
	countryCode VARCHAR(75) null
);