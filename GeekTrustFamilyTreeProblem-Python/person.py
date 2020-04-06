import custom_exceptions
import constants
class Person:
    def __init__(self, name, gender, father=None, mother=None, spouse=None):
        self.name, self.gender, self.father, self.mother, self.spouse = name, gender, father, mother, spouse
        self.daughters, self.sons = [],[]
    def add_spouse(self, spouse):
        self.spouse = spouse
    def add_children(self, child):
        if(self.spouse is None or self.gender == constants.MALE):
            raise custom_exceptions.ChildAdditionFailed(constants.CHILD_ERROR)
        else:
            self.daughters.append(child) if child.gender == constants.FEMALE else self.sons.append(child)
            self.spouse.daughters.append(child) if child.gender == constants.FEMALE else self.spouse.sons.append(child)
            child.mother = self
            child.father = self.spouse
    '''
    family relations
    '''
    def get_spouse(self):
        return self.spouse

    def get_brother(self):
        if(self.mother is None):
            raise custom_exceptions.InadequateInformation(constants.INFORMATION_ERROR)
        else:
            result = []
            mother = self.mother
            sons = mother.sons
            for son in sons:
                if(self.name == son.name):
                    continue
                else:
                    result.append(son)
            return result

    def get_sister(self):
        if(self.mother is None):
            raise custom_exceptions.InadequateInformation(constants.INFORMATION_ERROR)
        else:
            result = []
            mother = self.mother
            daughters = mother.daughters
            for daughter in daughters:
                if(self.name == daughter.name):
                    continue
                else:
                    result.append(daughter)
            return result

    def get_children(self):
        return self.daughters + self.sons
    
    def get_paternal_aunt(self):
        if(self.father is None):
            raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        else:
            father = self.father
            return Person.get_sister(father)
            
    def get_paternal_uncle(self):
        if self.father is None:
            raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        else:
            father = self.father
            return Person.get_brother(father)
    
    def get_maternal_aunt(self):
        if self.mother is None:
            raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        else:
            mother = self.mother
            return Person.get_sister(mother)

    def get_maternal_uncle(self):
        if self.mother is None:
            raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        else:
            mother = self.mother
            return Person.get_brother(mother)
    
    def get_sister_in_law(self):
        result = []
        try:
            brothers = Person.get_brother(self)
        except custom_exceptions.InadequateInformation:
            brothers = None
        else:
            result.extend([brother.spouse for brother in brothers if brother.spouse is not None])
        if(self.spouse is not None):
            try:
                spouse_sisters = Person.get_sister(self.spouse)
            except custom_exceptions.InadequateInformation:
                spouse_sisters = None 
            else:
                result.extend(spouse_sisters)
        return result
        
    def get_brother_in_law(self):
        result = []
        try:
            sisters = Person.get_sister(self)
        except custom_exceptions.InadequateInformation:
            sisters = None
        else:
            result.extend([sister.spouse for sister in sisters if sister.spouse is not None])

        if(self.spouse is not None):
            try:
                spouse_brothers = Person.get_brother(self.spouse)
            except custom_exceptions.InadequateInformation:
                spouse_brothers = None 
            else:
                result.extend(spouse_brothers)
        return result