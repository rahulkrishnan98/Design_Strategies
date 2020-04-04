from person import Person
from family import Family
import custom_exceptions
import argparse

if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("input_file", type=str)
    args = parser.parse_args()

    King_Shan = Person("King Shan","M")
    family = Family(King_Shan)
    
    #Creation of the Universe
    Queen_Anga = Person("Queen Anga","F")

    Chit = Person("Chit", "M")
    Amba = Person("Amba", "F")
    Ish = Person("Ish", "M")
    Vich = Person("Vich", "M")
    Lika = Person("Lika","F")
    Aras = Person("Aras","M")
    Chitra = Person("Chitra","F")
    Satya = Person("Satya", "F")
    Vyan = Person("Vyan", "M")

    Dritha = Person("Dritha","F")
    Jaya = Person("Jaya","M")
    Tritha = Person("Tritha","F")
    Vritha = Person("Vritha","M")
    Vila = Person("Vila","F")
    Chika = Person("Chika","F")
    Arit = Person("Arit","M")
    Jnki = Person("Jnki","F")
    Ahit = Person("Ahit","M")
    Satvy = Person("Satvy","F")
    Asva = Person("Asva","M")
    Krpi = Person("Krpi", "F")
    Vyas = Person("Vyas", "M")
    Atya = Person("Atya","F")

    Yodhan = Person("Yodhan", "M")
    Laki = Person("Laki", "M")
    Lavnya = Person("Lavnya", "F")
    Vasa = Person("Vasa", "M")
    Kriya = Person("Kriya", "M")
    Krithi = Person("Krithi", "F")

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
    input_file = open(args.input_file, "r")
    for line in input_file:
        query = line.split(" ")
        query[-1] = query[-1][:-1]

        if(query[0] == 'GET_RELATIONSHIP'):
            try:
                member = family.search_member(query[1])
                result = family.get_relationship(member, query[2])
            except (custom_exceptions.NullPointer):
                print("NONE")
            except (custom_exceptions.CommandNotFound):
                print("INVALID COMMAND")
            except (custom_exceptions.PersonNotFound):
                print("PERSON NOT FOUND")
            except (custom_exceptions.InadequateInformation):
                print("INADEQUATE INFORMATION")
            else:
                print(" ".join(result))
        elif(query[0] == "ADD_CHILD"):
            if(query[3] == "Female"):
                gender = "F"
            else:
                gender = "M"
            try:
                new_child = Person(query[2], gender)
                mother = family.search_member(query[1])
                family.add_child_in_family(mother, new_child)
            except (custom_exceptions.PersonNotFound):
                print("PERSON NOT FOUND")
            except (custom_exceptions.ChildAdditionFailed):
                print("CHILD ADDITION FAILED")
            else:
                print("CHILD ADDITION SUCCEEDED")
