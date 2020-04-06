from person import Person
from family import Family
import custom_exceptions
import constants
import argparse

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("input_file", type=str)
    args = parser.parse_args()

    King_Shan = Person("King Shan",constants.MALE)
    family = Family(King_Shan)
    
    #Creation of the Universe
    Queen_Anga = Person("Queen Anga",constants.FEMALE)

    Chit = Person("Chit", constants.MALE)
    Amba = Person("Amba", constants.FEMALE)
    Ish = Person("Ish", constants.MALE)
    Vich = Person("Vich", constants.MALE)
    Lika = Person("Lika",constants.FEMALE)
    Aras = Person("Aras",constants.MALE)
    Chitra = Person("Chitra",constants.FEMALE)
    Satya = Person("Satya", constants.FEMALE)
    Vyan = Person("Vyan", constants.MALE)

    Dritha = Person("Dritha",constants.FEMALE)
    Jaya = Person("Jaya",constants.MALE)
    Tritha = Person("Tritha",constants.FEMALE)
    Vritha = Person("Vritha",constants.MALE)
    Vila = Person("Vila",constants.FEMALE)
    Chika = Person("Chika",constants.FEMALE)
    Arit = Person("Arit",constants.MALE)
    Jnki = Person("Jnki",constants.FEMALE)
    Ahit = Person("Ahit",constants.MALE)
    Satvy = Person("Satvy",constants.FEMALE)
    Asva = Person("Asva",constants.MALE)
    Krpi = Person("Krpi", constants.FEMALE)
    Vyas = Person("Vyas", constants.MALE)
    Atya = Person("Atya",constants.FEMALE)

    Yodhan = Person("Yodhan", constants.MALE)
    Laki = Person("Laki", constants.MALE)
    Lavnya = Person("Lavnya", constants.FEMALE)
    Vasa = Person("Vasa", constants.MALE)
    Kriya = Person("Kriya", constants.MALE)
    Krithi = Person("Krithi", constants.FEMALE)

    #Relating the population
    family.add_spouse_in_family(King_Shan, Queen_Anga)
    family.add_child_in_family(Queen_Anga, Chit)
    family.add_child_in_family(Queen_Anga, Ish)
    family.add_child_in_family(Queen_Anga, Vich)
    family.add_child_in_family(Queen_Anga, Aras)
    family.add_child_in_family(Queen_Anga, Satya)

    family.add_spouse_in_family(Chit, Amba)
    family.add_child_in_family(Amba, Dritha)
    family.add_child_in_family(Amba, Tritha)
    family.add_child_in_family(Amba, Vritha)

    family.add_spouse_in_family(Vich, Lika)
    family.add_child_in_family(Lika, Vila)
    family.add_child_in_family(Lika, Chika)

    family.add_spouse_in_family(Aras, Chitra)
    family.add_child_in_family(Chitra, Jnki)
    family.add_child_in_family(Chitra, Ahit)

    family.add_spouse_in_family(Satya, Vyan)
    family.add_child_in_family(Satya, Asva)
    family.add_child_in_family(Satya, Vyas)
    family.add_child_in_family(Satya, Atya)

    family.add_spouse_in_family(Dritha, Jaya)
    family.add_child_in_family(Dritha, Yodhan)

    family.add_spouse_in_family(Jnki, Arit)
    family.add_child_in_family(Jnki, Laki)
    family.add_child_in_family(Jnki, Lavnya)

    family.add_spouse_in_family(Asva, Satvy)
    family.add_child_in_family(Satvy, Vasa)

    family.add_spouse_in_family(Vyas, Krpi)
    family.add_child_in_family(Krpi, Kriya)
    family.add_child_in_family(Krpi, Krithi)

    #Queries
    with open(args.input_file, 'r') as file:
        lines = file.readlines()
    for line in lines:
        line = line.rstrip('\n')
        query = line.split(" ")
        if(query[0] == 'GET_RELATIONSHIP'):
            try:
                member = family.search_member(query[1])
                result = family.get_relationship(member, query[2])
            except (custom_exceptions.NullPointer):
                print(constants.NULLPOINTER_ERROR)
            except (custom_exceptions.CommandNotFound):
                print(constants.COMMAND_ERROR)
            except (custom_exceptions.PersonNotFound):
                print(constants.PERSON_ERROR)
            except (custom_exceptions.InadequateInformation):
                print(constants.INFORMATION_ERROR)
            else:
                print(" ".join(result))
        elif(query[0] == "ADD_CHILD"):
            if(query[3] == "Female"):
                gender = constants.FEMALE
            else:
                gender = constants.MALE
            try:
                new_child = Person(query[2], gender)
                mother = family.search_member(query[1])
                family.add_child_in_family(mother, new_child)
            except (custom_exceptions.PersonNotFound):
                print(constants.PERSON_ERROR)
            except (custom_exceptions.ChildAdditionFailed):
                print(constants.CHILD_ERROR)
            else:
                print(constants.CHILD_ADDITION_SUCCESS)
