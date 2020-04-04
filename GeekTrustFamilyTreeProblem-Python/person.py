import custom_exceptions
class Person:
    def __init__(self, name, gender, father=None, mother=None, spouse=None):
        self.name, self.gender, self.father, self.mother, self.spouse = name, gender, father, mother, spouse
        self.daughters, self.sons = [],[]
    def add_spouse(self, spouse):
        self.spouse = spouse
    def add_children(self, child):
        self.daughters.append(child) if child.gender == 'F' else self.sons.append(child)
    '''
    family relations
    '''
    @staticmethod
    def get_spouse(person):
        return person.spouse

    @staticmethod
    def get_brother(person):
        if(person.mother is None):
            raise custom_exceptions.InadequateInformation("Inadequate Information")
        else:
            result = []
            mother = person.mother
            sons = mother.sons
            for son in sons:
                if(person.name == son.name):
                    continue
                else:
                    result.append(son)
            return result

    @staticmethod
    def get_sister(person):
        if(person.mother is None):
            raise custom_exceptions.InadequateInformation("Inadequate Information")
        else:
            result = []
            mother = person.mother
            daughters = mother.daughters
            for daughter in daughters:
                if(person.name == daughter.name):
                    continue
                else:
                    result.append(daughter)
            return result

    @staticmethod
    def get_children(person):
        return person.daughters + person.sons
    
    @staticmethod
    def get_paternal_aunt(person):
        if(person.father is None):
            raise custom_exceptions.NullPointer("NONE")
        else:
            father = person.father
            return Person.get_sister(father)
            
    @staticmethod
    def get_paternal_uncle(person):
        if person.father is None:
            raise custom_exceptions.NullPointer("NONE")
        else:
            father = person.father
            return Person.get_brother(father)
    
    @staticmethod
    def get_maternal_aunt(person):
        if person.mother is None:
            raise custom_exceptions.NullPointer("NONE")
        else:
            mother = person.mother
            return Person.get_sister(mother)

    @staticmethod
    def get_maternal_uncle(person):
        if person.mother is None:
            raise custom_exceptions.NullPointer("NONE")
        else:
            mother = person.mother
            return Person.get_brother(mother)
    
    @staticmethod
    def get_sister_in_law(person):
        result = []
        try:
            brothers = Person.get_brother(person)
        except custom_exceptions.InadequateInformation:
            brothers = None
        else:
            result.extend([brother.spouse for brother in brothers if brother.spouse is not None])
        if(person.spouse is not None):
            try:
                spouse_sisters = Person.get_sister(person.spouse)
            except custom_exceptions.InadequateInformation:
                spouse_sisters = None 
            else:
                result.extend(spouse_sisters)
        return result
        
    @staticmethod
    def get_brother_in_law(person):
        result = []
        try:
            sisters = Person.get_sister(person)
        except custom_exceptions.InadequateInformation:
            sisters = None
        else:
            result.extend([sister.spouse for sister in sisters if sister.spouse is not None])

        if(person.spouse is not None):
            try:
                spouse_brothers = Person.get_brother(person.spouse)
            except custom_exceptions.InadequateInformation:
                spouse_brothers = None 
            else:
                result.extend(spouse_brothers)
        return result