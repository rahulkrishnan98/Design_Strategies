from person import Person
import custom_exceptions
import constants

class Family:
    family_members = []
    def __init__(self, head):
        self.head = head
        self.family_members.append(head)
    
    def search_member(self, name):
        for member in (self.family_members):
            if(member.name ==  name):
                return member
        raise custom_exceptions.PersonNotFound(constants.PERSON_ERROR)
    

    '''
    Two ways to add members to family
    1) add_child
    2) add_spouse
    '''

    def add_child_in_family(self, mother, child):
        mother = Family.search_member(self, mother.name)
        if(mother.get_spouse() is None or mother.gender == constants.MALE):
            raise custom_exceptions.ChildAdditionFailed(constants.CHILD_ERROR)
        else:
            mother.add_children(child)
            mother.spouse.add_children(child)
            child.mother = mother
            child.father = mother.spouse
            self.family_members.append(child)
    
   
    def add_spouse_in_family(self, member, spouse):
        member = Family.search_member(self,member.name)
        member.add_spouse(spouse)
        spouse.add_spouse(member)
        self.family_members.append(spouse)

    
    def get_relationship(self, member, relation):
        if(relation == constants.SIBLINGS):
            result = Family.siblings(self, member)
        elif(relation == constants.PATERNAL_UNCLE):
            result = Family.uncle(self, member, constants.PATERNAL)
        elif(relation == constants.PATERNAL_AUNT):
            result = Family.aunt(self, member, constants.PATERNAL)
        elif(relation == constants.MATERNAL_UNCLE):
            result = Family.uncle(self, member, constants.MATERNAL)
        elif(relation == constants.MATERNAL_AUNT):
            result = Family.aunt(self, member, constants.MATERNAL)
        elif(relation == constants.COMMAND_SON):
            result = Family.children(self, member, constants.SON)
        elif(relation == constants.COMMAND_DAUGHTER):
            result = Family.children(self, member, constants.DAUGHTER)
        elif(relation == constants.SISTER_IN_LAW):
            result = Family.in_laws(self, member, constants.SISTER)
        elif(relation == constants.BROTHER_IN_LAW):
            result = Family.in_laws(self, member, constants.BROTHER)
        else:
            raise custom_exceptions.CommandNotFound(constants.COMMAND_ERROR)
        return result

    '''
    All relations
    '''
    def children(self, name, gender):
        person = Family.search_member(self, name.name)
        if(gender == constants.DAUGHTER):
            result = [per.name for per in person.daughters]
            if(result == []):
                raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        else:
            result = [per.name for per in person.sons]
            if(result == []):
                raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        return Family.in_order(self, result)

    def uncle(self, name, side):
        person = Family.search_member(self, name.name)
        if(side ==constants.PATERNAL):
            result = [per.name for per in person.get_paternal_uncle()]
            if(result == []):
                raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        else:
            result = [per.name for per in person.get_maternal_uncle()]
            if(result == []):
                raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        return Family.in_order(self, result)

    def aunt(self, name, side):
        person = Family.search_member(self, name.name)
        if(side ==constants.PATERNAL):
            result = [per.name for per in person.get_paternal_aunt()]
            if(result == []):
                raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        else:
            result = [per.name for per in person.get_maternal_aunt()]
            if(result == []):
                raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        return Family.in_order(self, result)

    def siblings(self, name):
        person = Family.search_member(self, name.name)
        result = [sibling.name for sibling in person.get_brother()+ person.get_sister()]
        if(result == []):
            raise custom_exceptions.NullPointer(constants.NULLPOINTER_ERROR)
        return Family.in_order(self, result)

    def in_laws(self, name, side):
        person = Family.search_member(self, name.name)
        if(side == constants.SISTER):
            result = [inlaw.name for inlaw in person.get_sister_in_law()]
        else:
            result = [inlaw.name for inlaw in person.get_brother_in_law()]
        return Family.in_order(self,result)
            

    '''
    Misc Functions
    '''
    def in_order(self, arr):
        result = []
        arr = [Family.search_member(self, arr[i]) for i in range(len(arr))]
        members = self.family_members
        for member in members:
            if(member in arr):
                result.append(member)
        result = [person.name for person in result]
        return result